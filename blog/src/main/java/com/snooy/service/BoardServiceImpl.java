package com.snooy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.snooy.dao.BoardDAO;
import com.snooy.vo.BoardVO;
import com.snooy.vo.Criteria;
import com.snooy.vo.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
		private BoardDAO dao;
	
	//게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		dao.write(boardVO);
	}
	
	//게시글 목록
	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		return dao.list(scri);
	}
	
	//게시물 총 갯수
	@Override
	public int listCount(SearchCriteria scri) throws Exception{
		return dao.listCount(scri);
	}
	
	//게시글 자세히
	@Override
	public BoardVO read(int board_num) throws Exception {
		return dao.read(board_num);
	}
	
	//게시글 수정
	@Override
	public void update(BoardVO boardVO) throws Exception {
		dao.update(boardVO);
	}
	
	//게시글 삭제
	@Override
	public void delete(int board_num) throws Exception {
		dao.delete(board_num);
	}

}
