package com.icia.mbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbc.dto.Boards;
import com.icia.mbc.dto.Search;
import com.icia.mbc.service.BService;

@Controller
public class BController {

	private ModelAndView mav = new ModelAndView();

	@Autowired
	private BService bsvc;

	// writeForm 게시글 작성 페이지로
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm() {
		return "board/write";
	}

	// bWrite : 게시글작성 메소드
	@RequestMapping(value = "/bWrite", method = RequestMethod.POST)
	public ModelAndView bWrite(@ModelAttribute Boards board) {
		mav = bsvc.bWrite(board);
		return mav;
	}

	// bView?bNum=게시글 번호 : 게시글 상세보기
	@RequestMapping(value = "/bView", method = RequestMethod.GET)
	public ModelAndView bWrite(@RequestParam("bNum") int bNum) {
		mav = bsvc.bView(bNum);
		return mav;
	}

	// bModify : 게시글 수정
	@RequestMapping(value = "/bModify", method = RequestMethod.POST)
	public ModelAndView bModify(@ModelAttribute Boards board) {
		mav = bsvc.bModify(board);
		return mav;
	}

	// bDelete : 게시글 삭제
	@RequestMapping(value = "/bDelete", method = RequestMethod.GET)
	public ModelAndView bDelete(@ModelAttribute Boards board) {
		mav = bsvc.bDelete(board);
		return mav;
	}
	// bList 페이징처리
	@RequestMapping(value = "/bList", method = RequestMethod.GET)
	public ModelAndView bList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int limit) {
		mav = bsvc.bList(page, limit);
		return mav;
	}
	//bSearch : 게시글 검색
	@RequestMapping(value = "/bSearch", method = RequestMethod.GET)
	public ModelAndView bSearch(@ModelAttribute Search search) {
		mav = bsvc.bSearch(search);
		return mav;
	}
	// modifyForm?bNum=게시글 번호
		@RequestMapping(value = "/modifyForm", method = RequestMethod.GET)
		public ModelAndView modifyForm(@RequestParam("bNum") int bNum) {
			System.out.println("\n게시글 수정페이지 이동 메소드");
			System.out.println("[1]jsp → controller : " + bNum);
			
			mav = bsvc.modifyForm(bNum);
			System.out.println("[5]service → controller : " + mav);
			
			return mav;
		}
}

