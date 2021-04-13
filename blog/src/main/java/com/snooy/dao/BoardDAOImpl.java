package com.snooy.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.snooy.vo.BoardVO;
import com.snooy.vo.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Inject
	private SqlSession sqlSession;
	
	//게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVO);
	}

	//게시글 목록 조회
	@Override
	public List<BoardVO> list(Criteria cri) throws Exception {
		return sqlSession.selectList("boardMapper.listPage", cri);
	}

	//게시물 총 갯수
	@Override
	public int listCount() throws Exception {
		return sqlSession.selectOne("boardMapper.listCount");
	}

	//게시물 보기
	@Override
	public BoardVO read(int board_num) throws Exception {
		return sqlSession.selectOne("boardMapper.read",board_num);
	}
	
	//게시물 수정
	@Override
	public void update(BoardVO boardVO) throws Exception {
		sqlSession.update("boardMapper.update", boardVO);
	}

	//게시물 삭제
	@Override
	public void delete(int board_num) throws Exception {
		sqlSession.delete("boardMapper.delete", board_num);
	}
}
