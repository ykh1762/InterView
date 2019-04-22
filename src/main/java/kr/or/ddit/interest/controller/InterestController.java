package kr.or.ddit.interest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.interest.model.InterestVo;
import kr.or.ddit.interest.service.IInterestService;
import kr.or.ddit.member.model.MemberVo;

@Controller
public class InterestController {
	private Logger logger = LoggerFactory.getLogger(InterestController.class);
	
	@Resource(name="interestService")
	private IInterestService inteService;
	
	// 관심분야 페이지 요청.
	@RequestMapping("/interest")
	public String interest(Model model){
		String[] arr_job = new String[]{"소프트웨어개발", "백엔드", "모바일앱개발", "웹마스터", 
				"데이터베이스", "클라이언트개발", "네트워크구축", "DBMS", "솔루션", "DataMining", 
				"네트워크보안", "유지보수", "공공기관", "전자상거래", "웹컨텐츠", "웹테스터", 
				"소프트웨어QA", "리눅스", "안드로이드", "C++", "Java", "HTTP·TCP", "통신", "POS", 
				"모바일기획", "서버관리", "시스템운영", "Framework", "springboot", "Nodejs", 
				"알고리즘", ".NET", "웹프로그래밍", "Python", "빅데이터", "머신러닝", "asp", 
				"Oracle", "MS-SQL", "SM", "SI", "WAS", "jsp", "DBA"};	
		
		List<String> jobList = new ArrayList<>();
		for(String job : arr_job){
			jobList.add(job);
		}
		
		// jobList 정렬.
        Collections.sort(jobList, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((String) o1).compareTo((String) o2);
			}
        });	
		
		model.addAttribute("jobList", jobList);
		
		// localList
		String[] arr_local = new String[]{"서울", "경기", "인천", "대전", "세종", "충남", "충북", 
				"광주", "전남", "전북", "대구", "경북", "부산", "울산", "경남", "강원", "제주"};
		
		List<String> localList = new ArrayList<>();
		for(String local : arr_local){
			localList.add(local);
		}
		
		model.addAttribute("localList", localList);	
		
		// empList
		String[] arr_emp = new String[]{"정규직", "계약직", "인턴", "파견직", "도급", "프리랜서"};
		
		List<String> empList = new ArrayList<>();
		for(String emp : arr_emp){
			empList.add(emp);
		}
		
		model.addAttribute("empList", empList);	
		
		return "interestTiles";
	}
	
	// @관심분야 등록.
	@RequestMapping("/insertInte")
	public String insertInte(HttpServletRequest req, String inte_type, String inte_local, String inte_emptype, 
			String inte_size, String change_flag, String tell_content, String job_condition, 
			HttpSession session) {
		logger.debug("inte_type? : {}", inte_type);
		
		// mem_id로 검색되는 관심분야가 있으면 update, 없으면 insert.
		MemberVo mVo = (MemberVo) session.getAttribute("SESSION_MEMBERVO");
		InterestVo iVo = inteService.getInte(mVo.getMem_id());
		if(iVo != null){
			iVo.setInte_emptype(inte_emptype);
			iVo.setInte_local(inte_local);
			iVo.setInte_size(inte_size);
			iVo.setInte_type(inte_type);
			iVo.setChange_flag(change_flag);
			iVo.setTell_content(tell_content);
			iVo.setJob_condition(job_condition);
			
			inteService.updateInte(iVo);
		}else{
			iVo = new InterestVo();
			iVo.setInte_code(String.valueOf(inteService.getInteCnt()+1));
			
			iVo.setUser_id(mVo.getMem_id());
			
			iVo.setInte_emptype(inte_emptype);
			iVo.setInte_local(inte_local);
			iVo.setInte_size(inte_size);
			iVo.setInte_type(inte_type);
			iVo.setChange_flag(change_flag);
			iVo.setTell_content(tell_content);
			iVo.setJob_condition(job_condition);			
			
			inteService.insertInte(iVo);
		}

		return "redirect:" + req.getContextPath() + "/recruit";
	}
	
	

}







