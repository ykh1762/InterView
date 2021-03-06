package kr.or.ddit.search_log.service;

import java.util.List;

import kr.or.ddit.search_log.model.Search_logVo;

public interface ISearch_logService {

	/**
	 * 
	 * Method : getAllCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 검색내역 수를 조회.
	 */
	int getAllCnt();

	/**
	 * 
	 * Method : insertSearch_log
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sVo
	 * @return
	 * Method 설명 : 검색내역 등록.
	 */
	int insertSearch_log(Search_logVo sVo);

	/**
	 * 
	 * Method : getSaveList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sVo
	 * @return
	 * Method 설명 : 저장한 검색어 리스트 조회.
	 */
	List<Search_logVo> getSaveList(Search_logVo sVo);
	
	/**
	 * 
	 * Method : getSearch_log
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param search_code
	 * @return
	 * Method 설명 : 특정 검색내역 조회.
	 */
	Search_logVo getSearch_log(String search_code);
	
	/**
	 * 
	 * Method : deleteSearch_logForTest
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param search_code
	 * @return
	 * Method 설명 : 테스트 코드를 위한 검색내역 삭제.
	 */
	int deleteSearch_logForTest(String search_code);

	/**
	 * 
	 * Method : updateSearch_log
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sVo
	 * @return
	 * Method 설명 : 검색내역 수정.
	 */
	int updateSearch_log(Search_logVo sVo);

	/**
	 * 
	 * Method : getLSLog
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 특정 회원이 검색하려는 값 조회.
	 */
	Search_logVo getLSLog(String mem_id);

	/**
	 * 
	 * Method : getSList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 특정 유저의 최근 검색어 리스트 조회.
	 */
	List<Search_logVo> getSList(String mem_id);

	/**
	 * 
	 * Method : updateSLogNotDel
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sVo
	 * @return
	 * Method 설명 : 검색내역 수정. (del_flag가 '1'인 경우)
	 */
	int updateSLogNotDel(Search_logVo sVo);

	/**
	 * 
	 * Method : getSLogByCond
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sVo
	 * @return
	 * Method 설명 : id, word, local로 특정 검색내역 조회.
	 */
	Search_logVo getSLogByCond(Search_logVo sVo);

	/**
	 * 
	 * Method : getWordList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 알람 설정된 검색어 목록 조회.
	 */
	List<String> getWordList();

	/**
	 * 
	 * Method : getAlarmUserList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param alarmWord
	 * @return
	 * Method 설명 : 특정 검색어 알람을 설정한 유저 목록 조회.
	 */
	List<String> getAlarmUserList(String alarmWord);

	
	
	
	
	
}






