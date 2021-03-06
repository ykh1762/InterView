package kr.or.ddit.follow.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.follow.model.FollowVo;
import kr.or.ddit.util.pagination.PaginationVo;

@Repository("followDao")
public class FollowDaoImpl implements IFollowDao {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insert_follow(FollowVo followVo) {
		return sqlSession.insert("follow.insert_follow", followVo);
	}

	@Override
	public int delete_follow(FollowVo followVo) {
		return sqlSession.delete("follow.delete_follow", followVo);
	}

	@Override
	public List<FollowVo> select_followList(String mem_id) {
		return sqlSession.selectList("follow.select_followList", mem_id); 
	}

	@Override
	public List<FollowVo> select_followKindList(PaginationVo paginationVo) {
		return sqlSession.selectList("follow.select_followKindList", paginationVo);
	}

	@Override
	public int getFollowingCnt(String mem_id) {
		return sqlSession.selectOne("follow.getFollowingCnt", mem_id);
	}

	@Override
	public int getFollowerCnt(String mem_id) {
		return sqlSession.selectOne("follow.getFollowerCnt", mem_id);
	}
	
	@Override
	public List<FollowVo> select_followerList(String mem_id) {
		return sqlSession.selectList("follow.select_followerList", mem_id);
	}
	
	@Override
	public List<FollowVo> select_followingList(String mem_id) {
		return sqlSession.selectList("follow.select_followingList", mem_id);
	}

	/**
	 * Method : select_oneFollow
	 * 작성자 : jin
	 * 변경이력 :
	 * @param followVo
	 * @return
	 * Method 설명 : 사용자와 상대방과의 팔로우 검색
	 */
	@Override
	public FollowVo select_oneFollow(FollowVo followVo) {
		return sqlSession.selectOne("follow.select_oneFollow", followVo);
	}

	@Override
	public int select_hashtagFollowCount(String ref_keyword) {
		return sqlSession.selectOne("follow.select_hashtagFollowCount", ref_keyword);
	}

	@Override
	public int select_followHashtagInfo(FollowVo followVo) {
		return sqlSession.selectOne("follow.select_followHashtagInfo", followVo);
	}

	@Override
	public int delete_personalFollow(String follow_code) {
		return sqlSession.delete("follow.delete_personalFollow", follow_code);
	}

	@Override
	public int insert_feedFollow(FollowVo followVo) {
		return sqlSession.insert("follow.insert_feedFollow", followVo);
	}

	/**
	 * Method : select_followChatList
	 * 작성자 : jin
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 채팅 초대할 유저의 팔로우들(회사,회원)
	 */
	@Override
	public List<Map<String, String>> select_followChatList(String mem_id) {
		return sqlSession.selectList("follow.select_followChatList", mem_id);
	}
	
	@Override
	public int insert_corpFollow(FollowVo followVo) {
		return sqlSession.insert("follow.insert_corpFollow", followVo);
	}

	@Override
	public int delete_corpFollow(FollowVo followVo) {
		return sqlSession.delete("follow.delete_corpFollow", followVo);
	}
	
	@Override
	public int insert_userFollow(FollowVo followVo) {
		return sqlSession.insert("follow.insert_userFollow", followVo);
	}
	
	@Override
	public int delete_userFollow(FollowVo followVo) {
		return sqlSession.delete("follow.delete_userFollow", followVo);
	}

	/**
	 * Method : select_hashtagFJollowList
	 * 작성자 : jin
	 * 변경이력 :
	 * @param user_id
	 * @return
	 * Method 설명 : 유저가 팔로우한 해쉬태그 리스트 조회
	 */
	@Override
	public List<FollowVo> select_hashtagFollowList(String user_id) {
		return sqlSession.selectList("follow.select_hashtagFollowList", user_id);
	}

	@Override
	public FollowVo select_followLog(FollowVo vo) {
		return sqlSession.selectOne("follow.select_followLog", vo);
	}

	@Override
	public List<FollowVo> select_userFollowList(String mem_id) {
		return sqlSession.selectList("follow.select_userFollowList", mem_id);
	}

}


