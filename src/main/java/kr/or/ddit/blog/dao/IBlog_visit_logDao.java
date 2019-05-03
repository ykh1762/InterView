package kr.or.ddit.blog.dao;

import java.util.List;

import kr.or.ddit.blog.model.Blog_visit_logVo;

public interface IBlog_visit_logDao {
	
	/**
	 * 
	 * Method : insert_visit_log
	 * 작성자 : pjk
	 * 변경이력 :
	 * @param vo
	 * @return
	 * Method 설명 : 방문 기록 입력 
	 */
	int insert_visit_log(Blog_visit_logVo vo);
	
}
