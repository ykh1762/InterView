package kr.or.ddit.search_log.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.search_log.model.Search_logVo;
import kr.or.ddit.search_log.service.ISearch_logService;

@Controller
public class Search_logController {
	private Logger logger = LoggerFactory.getLogger(Search_logController.class);

	@Resource(name="search_logService")
	private ISearch_logService sLogService;
	
	// @검색내역 저장.
	@RequestMapping("/insertSLog")
	public String insertSLog(String search_word, String search_local, HttpSession session, HttpServletRequest req, 
			Model model) {
		// 검색어 DB에 저장하기
		Search_logVo sVo = new Search_logVo();
		
		if(search_word == null || search_word.equals("")){
			sVo.setSearch_word("전체");
		}else{
			sVo.setSearch_word(search_word);
		}
		
		if(search_local == null || search_local.equals("")){
			sVo.setSearch_local("전국");
		}else{
			sVo.setSearch_local(search_local);			
		}
		
		sVo.setSearch_code(String.valueOf(sLogService.getAllCnt()+1));
		
		MemberVo mVo = (MemberVo) session.getAttribute("SESSION_MEMBERVO");
		if(mVo != null){
			sVo.setUser_id(mVo.getMem_id());
		}else{
			// 유저정보 없을경우 로그인 페이지로 이동.
			return "redirect:" + req.getContextPath() + "/login";
		}
		
		// search_save, sarch_alarm은 id/word/local로 검색한뒤 데이터가 없으면 default (save-1, alarm-1), 
		// 있으면 그 데이터의 값으로 설정해야 함
		Search_logVo compSVo = sLogService.getSLogByCond(sVo);
		
		if(compSVo == null){
			sVo.setSearch_save("1");
			sVo.setSearch_alarm("1");
		}else{
			sVo.setSearch_save(compSVo.getSearch_save());
			sVo.setSearch_alarm(compSVo.getSearch_alarm());
		}
		
		sVo.setDel_flag("1");
		
		sLogService.insertSearch_log(sVo);		

		return "redirect:" + req.getContextPath() + "/recrSearch";
	}
	
	// @검색내역 저장여부 수정.
	@RequestMapping("/updateSave")
	public String updateSave(String save_flag, String search_code, HttpServletRequest req) {
		// save_flag 't'를 받으면 - 검색내역 저장 해제. - search_save를 '1'로 변경.
		if(save_flag != null && save_flag.equals("t")){
			Search_logVo sVo = sLogService.getSearch_log(search_code);
			sVo.setSearch_save("1");
			
			sLogService.updateSearch_log(sVo);
		}

		return "redirect:" + req.getContextPath() + "/recruit";
	}
	
	// @채용공고 알림여부 수정.
	@RequestMapping("/updateAlarm")
	public String updateAlarm(HttpServletRequest req, String search_alarm, String search_code) {
		Search_logVo sVo = sLogService.getSearch_log(search_code);
		
		if(search_alarm.equals("2")){
			// 알람 끄기.
			sVo.setSearch_alarm("1");
		}else{
			sVo.setSearch_alarm("2");
		}
		
		sLogService.updateSLogNotDel(sVo);

		return "redirect:" + req.getContextPath() + "/recruit";
	}
	
	// @수정한 전체 검색내역 업데이트.
	@RequestMapping("/updateAllAlarm")
	public String updateAllAlarm(HttpServletRequest req, String result, String req_page, Model model) {
		// result parsing. split("\\?\\?\\?"): [0]-save, [1]-search
		String data_save = result.split("\\?\\?\\?")[0];
		String data_search = result.split("\\?\\?\\?")[1];
		
		// split("::")후 length 확인. - 갯수만큼 나옴.
		String[] arr_save = data_save.split("::");
		String[] arr_search = data_search.split("::");
		
		// split("/")후 data 확인. - ok. - search_code/search_alarm/search_save
		if( ! arr_save[0].startsWith("xxx")){
			for(int i=0; i < arr_save.length; i++){
				String search_code = arr_save[i].split("/")[0];
				String search_alarm = arr_save[i].split("/")[1];
				String search_save = arr_save[i].split("/")[2];
				
				Search_logVo sVo = sLogService.getSearch_log(search_code);
				sVo.setSearch_alarm(search_alarm);
				sVo.setSearch_save(search_save);
				
				sLogService.updateSLogNotDel(sVo);
			}
		}
		
		// search_code/search_save/del
		if( ! arr_search[0].startsWith("xxx")){
			for(int i=0; i < arr_search.length; i++){
				String search_code = arr_search[i].split("/")[0];
				String search_save = arr_search[i].split("/")[1];
				String del_flag = arr_search[i].split("/")[2];
				
				// del_flag '1'은 다른 쿼리(updateSLogNotDel) 사용.
				Search_logVo sVo = sLogService.getSearch_log(search_code);
				sVo.setSearch_save(search_save);
				
				if(del_flag.equals("2")){
					sLogService.updateSearch_log(sVo);
				}else{
					sLogService.updateSLogNotDel(sVo);
				}
			}
		}
		
//		logger.debug("result? : {}", result);
		// 다른 페이지에서 요청시 req_page 확인.
		if(req_page != null && req_page.equals("recrSearch")){
			return "redirect:" + req.getContextPath() + "/recrSearch";
		}
		
		return "redirect:" + req.getContextPath() + "/recruit";
	}
	
	
	

}





