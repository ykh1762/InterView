package kr.or.ddit.save_recruit.service;

import java.util.List;

import kr.or.ddit.save_recruit.model.Save_recruitVo;

public interface ISave_recruitService {

	/**
	 * 
	 * Method : insertSrecr
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param sVo
	 * @return
	 * Method 설명 : 채용공고저장 등록.
	 */
	int insertSrecr(Save_recruitVo sVo);

	/**
	 * 
	 * Method : deleteForTest
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param string
	 * @return
	 * Method 설명 : 테스트를 위한 채용공고저장 삭제.
	 */
	int deleteForTest(String string);

	/**
	 * 
	 * Method : getSrecrCnt
	 * 작성자 : PC19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 채용공고저장 수 조회.
	 */
	int getSrecrCnt();

	/**
	 * 
	 * Method : getUserSrecrList
	 * 작성자 : PC19
	 * 변경이력 :
	 * @param user_id
	 * @return
	 * Method 설명 : 특정 유저의 전체 채용공고저장 목록 조회.
	 */
	List<Save_recruitVo> getUserSrecrList(String user_id);
	
	
}






