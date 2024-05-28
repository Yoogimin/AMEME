package com.icia.mbc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbc.dto.Members;
import com.icia.mbc.dto.Search;
import com.icia.mbc.service.MService;

@Controller
public class MController {

	@Autowired
	private MService msvc;

	@Autowired
	private HttpSession session;

	private ModelAndView mav = new ModelAndView();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index1() {
		return "index";
	}

	// joinForm : 회원가입 페이지로 이동
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "member/join";
	}

	// loginForm : 로그인 페이지로 이동
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "member/login";
	}

	// idCheck : 아이디 중복체크
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public @ResponseBody String idCheck(@RequestParam("mId") String mId) {
		System.out.println("[1] :" + mId);
		String result = msvc.idCheck(mId);

		return result;
	}

	// mJoin : 회원가입
	@RequestMapping(value = "/mJoin", method = RequestMethod.POST)
	public ModelAndView mJoin(@ModelAttribute Members member) {

		mav = msvc.mJoin(member);

		return mav;
	}

	// mLogin : 로그인
	@RequestMapping(value = "/mLogin", method = RequestMethod.POST)
	public ModelAndView mLogin(@ModelAttribute Members member) {

		mav = msvc.mLogin(member);

		return mav;
	}

	// mList : 회원목록
	@RequestMapping(value = "/mList", method = RequestMethod.GET)
	public ModelAndView mList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "list", required = false, defaultValue = "5") int limit) {
		mav = msvc.mList(page, limit);
		return mav;
	}

	// mView : 회원 상세 보기
	@RequestMapping(value = "/mView", method = RequestMethod.GET)
	public ModelAndView mView(@RequestParam("mId") String mId) {

		mav = msvc.mView(mId);

		return mav;
	}

	// mModiForm : 회원 수정
	@RequestMapping(value = "/mModiForm", method = RequestMethod.GET)
	public ModelAndView mModiForm(@RequestParam("mId") String mId) {
		mav = msvc.mModiForm(mId);

		return mav;
	}

	// mModify : 회원 수정
	@RequestMapping(value = "/mModify", method = RequestMethod.POST)
	public ModelAndView mModify(@ModelAttribute Members member) {
		mav = msvc.mModify(member);

		return mav;
	}

	// mDelete : 회원 삭제
	@RequestMapping(value = "/mDelete", method = RequestMethod.GET)
	public ModelAndView mDelete(@RequestParam("mId") String mId, @RequestParam("mProfileName") String mProfileName) {
		mav = msvc.mDelete(mId, mProfileName);
		session.invalidate();
		return mav;
	}
	// mSearch : 회원검색
	@RequestMapping(value="/mSearch", method=RequestMethod.GET)
	public ModelAndView mSearch(@ModelAttribute Search search) {
		mav = msvc.mSearch(search);
		return mav;
	}
	// mLogout : 로그아웃
	@RequestMapping(value = "/mLogout", method = RequestMethod.GET)
	public String mLogout() {
		
		session.invalidate();
		
		//리턴 값을 index로 설정
		return "index";
	}
}
