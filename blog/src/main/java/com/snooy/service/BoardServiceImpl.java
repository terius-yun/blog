package com.snooy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.snooy.dao.BoardDAO;
import com.snooy.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
		private BoardDAO dao;
	@Override
	public void write(BoardVO boardVO) throws Exception {
		dao.write(boardVO);
		
	}
	@Override
	public List<BoardVO> list() throws Exception {
		return dao.list();
	}
	@Override
	public BoardVO read(int board_num) throws Exception {
		return dao.read(board_num);
	}
	@Override
	public void update(BoardVO boardVO) throws Exception {
		dao.update(boardVO);
	}
	@Override
	public void delete(int board_num) throws Exception {
		dao.delete(board_num);
	}

}
