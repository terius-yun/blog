package com.snooy.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.snooy.service.BoardService;
import com.snooy.vo.BoardVO;
import com.snooy.vo.Criteria;
import com.snooy.vo.PageMaker;
import com.snooy.vo.SearchCriteria;

@Controller
public class BoardContoller {
	private static final Logger logger = LoggerFactory.getLogger(BoardContoller.class);
	
	@Inject
	BoardService service;
	
	//게시판 글 작성 화면
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
	}
	
	//게시판 글 작성
	@RequestMapping(value = "board/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception{
		logger.info("write");
		
		service.write(boardVO);
		
		return "redirect:/";
	}
	
	//게시글 목록
	@RequestMapping(value = "board/list", method = RequestMethod.GET)
	public String list(Model model, @ModelAttribute("scri")SearchCriteria scri) throws Exception{
		logger.info("list");
		
		model.addAttribute("list",service.list(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		model.addAttribute("pageMaker", pageMaker);
		return "board/list";
	}
	
	//게시글 조회
	@RequestMapping(value = "board/readView", method = RequestMethod.GET)
	public String read(BoardVO boardVO, @ModelAttribute("scri")SearchCriteria scri, Model model) throws Exception{
		logger.info("read");
	
		model.addAttribute("read",service.read(boardVO.getBoard_num()));
		model.addAttribute("scri",scri);
		
		return "board/readView";
	}
	
	// 게시글 수정뷰
	@RequestMapping(value = "board/updateView", method = RequestMethod.GET)
	public String updateView(BoardVO boardVO, @ModelAttribute("scri")SearchCriteria scri, Model model) throws Exception{
		logger.info("updateView");
			
		model.addAttribute("update", service.read(boardVO.getBoard_num()));
		model.addAttribute("scri",scri);
		
		return "board/updateView";
	}
		
	//게시글 수정
	@RequestMapping(value="board/update", method = RequestMethod.POST)
	public String update(BoardVO boardVO, @ModelAttribute("scri")SearchCriteria scri, RedirectAttributes rttr) throws Exception{
		logger.info("update");
		
		service.update(boardVO);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	//게시글 삭제
	@RequestMapping(value="board/delete", method = RequestMethod.POST)
	public String delete(BoardVO boardVO, @ModelAttribute("scri")SearchCriteria scri, RedirectAttributes rttr) throws Exception{
		logger.info("delete");
		
		service.delete(boardVO.getBoard_num());
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/list";
	}
}
