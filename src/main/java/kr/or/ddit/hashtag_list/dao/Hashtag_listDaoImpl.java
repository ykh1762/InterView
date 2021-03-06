package kr.or.ddit.hashtag_list.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.hashtag_list.model.Hashtag_listVo;

@Repository("hashtag_listDao")
public class Hashtag_listDaoImpl implements IHashtag_listDao {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insert_hashtaglist(Hashtag_listVo hashtag_listVo) {
		return sqlSession.insert("post.insert_hashtaglist", hashtag_listVo);
	}

	@Override
	public int update_hashtaglist(Hashtag_listVo hashtag_listVo) {
		return sqlSession.update("hashtag.update_hashtaglist", hashtag_listVo);
	}

	@Override
	public int delete_hashtaglist(Hashtag_listVo taglistVo) {
		return sqlSession.delete("hashtag.delete_hashtaglist", taglistVo);
	}

	@Override
	public List<Hashtag_listVo> select_hashtaglist(Hashtag_listVo hashtag_listVo) {
		return sqlSession.selectList("hashtag.select_hashtaglist", hashtag_listVo);
	}

}
