package com.icia.mbc.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbc.dao.MDao;
import com.icia.mbc.dto.Members;
import com.icia.mbc.dto.Paging;
import com.icia.mbc.dto.Search;

@Service
public class MService {

	@Autowired
	private MDao mdao;

	@Autowired
	private BCryptPasswordEncoder pwEnc;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpSession session;

	private ModelAndView mav;

	public String savePath() {
		return request.getServletContext().getRealPath("src/main/webapp/resources/profile/")
				.replace(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\", "");
	}

	public String idCheck(String mId) {
		String result = null;

		String checkId = mdao.idcheck(mId);

		if (checkId == null) {
			result = "OK";
		} else {
			result = checkId;
		}

		return result;
	}

	public ModelAndView mJoin(Members member) {
		mav = new ModelAndView();

		member.setMPw(pwEnc.encode(member.getMPw()));

		String mAddr = "(" + member.getAddr1() + ")" + member.getAddr2() + ", " + member.getAddr3();
		member.setMAddr(mAddr);
		
		MultipartFile mProfile = member.getMProfile();

		String savePath = savePath();

		if (!mProfile.isEmpty()) {
			String uuid = UUID.randomUUID().toString().substring(0, 8);
			String fileName = mProfile.getOriginalFilename();
			String mProfileName = uuid + "_" + fileName;
			member.setMProfileName(mProfileName);

			try {
				mProfile.transferTo(new File(savePath + mProfileName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		} else {
			member.setMProfileName("default.png");
		}

		try {
			mdao.mJoin(member);
			mav.setViewName("member/login");
		} catch (Exception e) {
			mav.setViewName("member/join");
		}

		return mav;
	}

	public ModelAndView mLogin(Members member) {
		mav = new ModelAndView();

		Members login = mdao.mView(member.getMId());

		if (pwEnc.matches(member.getMPw(), login.getMPw())) {
			mav.setViewName("index");

			session.setAttribute("loginId", login.getMId());
			session.setAttribute("loginProfile", login.getMProfileName());
			session.setAttribute("loginName", login.getMName());

		} else {
			mav.setViewName("member/login");
		}

		return mav;
	}

	public ModelAndView mList(int page, int limit) {
		mav = new ModelAndView();

		int block = 5;

		int count = mdao.mCount();

		int maxPage = (int) Math.ceil((double) count / limit);

		int startRow = (page - 1) * limit + 1;

		int endRow = page * limit;

		int startPage = ((int) Math.ceil((double) page / block) - 1) * block + 1;

		int endPage = startPage + block - 1;

		if (endPage >= maxPage) {
			endPage = maxPage;
		}

		Paging paging = new Paging();

		paging.setStartRow(startRow);
		paging.setEndRow(endRow);

		paging.setPage(page);
		paging.setMaxPage(maxPage);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setLimit(limit);
		
		List<Members> memberList = mdao.mList(paging);
		
		mav.addObject("memberList", memberList);
		mav.addObject("paging", paging);
		
		mav.setViewName("member/list");
		

		return mav;
	}

	public ModelAndView mSearch(Search search) {
		mav = new ModelAndView();
		
		List<Members> searchList = mdao.mSearch(search);
		
		mav.addObject("memberList", searchList);
		mav.addObject("pages", 0);
		mav.setViewName("member/list");
		
		return mav;
	}

	public ModelAndView mView(String mId) {
		mav = new ModelAndView();
		
		Members member = mdao.mView(mId);
		
		mav.addObject("view", member);
		mav.setViewName("member/view");
		
		return mav;
	}

	public ModelAndView mModiForm(String mId) {
		mav = new ModelAndView();
		
		Members member = mdao.mView(mId);
		
		mav.addObject("modify", member);
		mav.setViewName("member/modify");
		
		return mav;
	}

	public ModelAndView mModify(Members member) {
		mav = new ModelAndView();

		member.setMPw(pwEnc.encode(member.getMPw()));

		String mAddr = "(" + member.getAddr1() + ")" + member.getAddr2() + ", " + member.getAddr3();
		member.setMAddr(mAddr);

		MultipartFile mProfile = member.getMProfile();

		String savePath = savePath();

		if (!mProfile.isEmpty()) {
			String uuid = UUID.randomUUID().toString().substring(0, 8);
			String fileName = mProfile.getOriginalFilename();
			String mProfileName = uuid + "_" + fileName;
			

			try {
				mProfile.transferTo(new File(savePath + mProfileName));

				File delFile = new File(savePath + member.getMProfileName());
				
				if(delFile.exists() && !member.getMProfileName().equals("default.png")) {
					delFile.delete();
				}
				
				member.setMProfileName(mProfileName);
				
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		} else {
			member.setMProfileName("default.png");
		}
		
		try { 
			mdao.mModify(member);
			mav.setViewName("redirect:/mView?mId=" + member.getMId());
			session.setAttribute("loginId", member.getMId());
			session.setAttribute("loginProfile", member.getMProfileName());
			
		} catch (Exception e) { 
			mav.setViewName("redirect:/mModiForm?mId=" + member.getMId());
		}

		return mav;
	}

	public ModelAndView mDelete(String mId, String mProfileName) {
		mav = new ModelAndView();
		
		try {
			mdao.mDelete(mId);
			mav.setViewName("redirect:/index");

			File delFile = new File(savePath() + mProfileName);
			
			if(delFile.exists() && !mProfileName.equals("default.png")) {
				delFile.delete();
			}
			
		} catch(Exception e) {
			mav.setViewName("redirect:/mView?mId="+mId);
		}
		
		return mav;
	}
}