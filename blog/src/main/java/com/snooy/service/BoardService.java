package com.snooy.service;

import java.util.List;

import com.snooy.vo.BoardVO;
import com.snooy.vo.Criteria;

public interface BoardService {
	
	//게시글 작성
	public void write(BoardVO boardVO)throws Exception;
	
	//게시글 목록
	public List<BoardVO> list(Criteria cri) throws Exception;
	
	//게시물 총 갯수
	public int listCount() throws Exception;
	
	//게시물 조회
	public BoardVO read(int board_num) throws Exception;
	
	//게시물 수정
	public void update(BoardVO boardVO)throws Exception;
		
	//게시물 삭제
	public void delete(int board_num) throws Exception;
}
