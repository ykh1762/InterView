package kr.or.ddit.possesion_skills.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.possesion_skills.dao.IPossesion_skillsDao;
import kr.or.ddit.possesion_skills.model.Possesion_skillsVo;

@Service("possesion_skillsService")
public class Possesion_skillsServiceImpl implements IPossesion_skillsService {

	@Resource(name="possesion_skillsDao")
	private IPossesion_skillsDao possesion_skillsDao;
	
	/**
	 * Method : insert_possesion_skills
	 * 작성자 : jin
	 * 변경이력 :
	 * @param possesion_skillsvo
	 * @return
	 * Method 설명 : 보유기술 등록
	 */
	@Override
	public int insert_possesion_skills(Possesion_skillsVo possesion_skillsvo) {
		return possesion_skillsDao.insert_possesion_skills(possesion_skillsvo);
	}

	/**
	 * Method : select_possesion_skills
	 * 작성자 : jin
	 * 변경이력 :
	 * @param user_id
	 * @return
	 * Method 설명 : 사용자 보유 기술 조회
	 */
	@Override
	public List<Possesion_skillsVo> select_possesion_skills(String user_id) {
		return possesion_skillsDao.select_possesion_skills(user_id);
	}

}
