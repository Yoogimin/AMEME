package com.icia.mbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.mbc.dto.Comments;
import com.icia.mbc.service.CService;

@Controller
public class CController {

	@Autowired
	private CService csvc;

	// cList : 댓글 목록
	@RequestMapping(value = "cList", method = RequestMethod.POST)
	public @ResponseBody List<Comments> cList(@RequestParam("cbNum") int cbNum) {
		System.out.println("[1] cbNum : " + cbNum);
		List<Comments> list = csvc.cList(cbNum);
		System.out.println("[5] list : " + list);
		return list;

	}

	// cWrite : 댓글 입력
	@RequestMapping(value = "cWrite", method = RequestMethod.POST)
	public @ResponseBody List<Comments> cWrite(@ModelAttribute Comments comment) {
		System.out.println("[1] cbNum : " + comment);
		List<Comments> list = csvc.cWrite(comment);
		System.out.println("[5] list : " + list);
		return list;
	}
	// cModify : 댓글 수정
	@RequestMapping(value = "cModify", method = RequestMethod.POST)
	public @ResponseBody List<Comments> cModify(@ModelAttribute Comments comment) {
		System.out.println("[1] cbNum : " + comment);
		List<Comments> list = csvc.cModify(comment);
		System.out.println("[5] list : " + comment);
		return list;
	}
	// cDelete : 댓글 삭제
	@RequestMapping(value = "cDelete", method = RequestMethod.POST)
	public @ResponseBody List<Comments> cDelete(@ModelAttribute Comments comment) {
		List<Comments> list = csvc.cDelete(comment);
		System.out.println("[5] list : " + comment);
		return list;
	}
}