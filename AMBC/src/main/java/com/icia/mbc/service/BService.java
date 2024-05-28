package com.icia.mbc.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mbc.dao.BDao;
import com.icia.mbc.dto.Boards;
import com.icia.mbc.dto.Paging;
import com.icia.mbc.dto.Search;

@Service
public class BService {
	
private ModelAndView mav;

@Autowired
private BDao bdao;

@Autowired
private HttpServletRequest request;

	public ModelAndView bWrite(Boards board) {
        System.out.println("[2]controller → sevice : " + board);
        mav = new ModelAndView();
        MultipartFile bFile = board.getBFile();
        
        if(!bFile.getOriginalFilename().isEmpty()) {
        	UUID uuid = UUID.randomUUID();
        	
        	String bFileName = uuid.toString().substring(0, 8) + "_" + bFile.getOriginalFilename();
        	board.setBFileName(bFileName);
            String savePath = request.getServletContext().getRealPath("src/main/webapp/resources/fileUpload/")
					.replace(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\", "");
                   try {
					bFile.transferTo(new File(savePath + bFileName));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				} else {
					board.setBFileName("default.jpg");
				}
        	int result = bdao.bWrite(board);
        	System.out.println("[4]dao → service : " + result);
        	if(result > 0) {
        		mav.setViewName("index");
        } else {
        	mav.setViewName("board/write");
        }
		return mav;
	}

	public ModelAndView bView(int bNum) {
		mav = new ModelAndView();
		
		int result = bdao.bConut(bNum);
		
		if(result > 0) {
			Boards board = bdao.bView(bNum);
			
			mav.addObject("view", board);
			mav.setViewName("board/view");
		} else {
			mav.setViewName("index");
		}
		return mav;
	}

	public ModelAndView bModify(Boards board) {
		System.out.println("[2]controller → service : " + board);
		mav = new ModelAndView();

		// 삭제할 파일 이름
		String delFileName = board.getBFileName();

		MultipartFile bFile = board.getBFile();

		if (!bFile.getOriginalFilename().isEmpty()) {

			UUID uuid = UUID.randomUUID();
			String bFileName = uuid.toString().substring(0, 8) + "_" + bFile.getOriginalFilename();
			board.setBFileName(bFileName);

			String savePath = request.getServletContext().getRealPath("src/main/webapp/resources/fileUpload/")
					.replace(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\", "");

			try {
				bFile.transferTo(new File(savePath + bFileName));

				// 저장경로(savePath)에 있는 파일(delFileName을 delFile에 담는다.
				File delFile = new File(savePath + delFileName);

				// 삭제하고자 하는 파일이 존재한다면
				if (delFile.exists()) {
					// 해당파일을 삭제한다.
					delFile.delete();
				}

			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}

		} else {
			board.setBFileName("default.jpg");
		}

		int result = bdao.bModify(board);
		System.out.println("[4]dao → service : " + result);

		if (result > 0) {
			mav.setViewName("redirect:/bView?bNum=" + board.getBNum());
		} else {
			mav.setViewName("redirect:/bList");
		}

		return mav;
	}

	public ModelAndView bDelete(Boards board) {
		System.out.println("[2]controller → service : " + board);
		mav = new ModelAndView();
		
		int result = bdao.bDelete(board.getBNum());
		System.out.println("[4]dao → service : " + result);

		if (result > 0) {

			String savePath = request.getServletContext().getRealPath("src/main/webapp/resources/fileUpload/")
					.replace(".metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\", "");

			File delFile = new File(savePath + board.getBFileName());

			if (delFile.exists()) {
				delFile.delete();
			}

			mav.setViewName("redirect:/bList");
		} else {
			mav.setViewName("redirect:/bView?bNum=" + board.getBNum());
		}

		return mav;
	}

	public ModelAndView bList(int page, int limit) {
		 
		mav = new ModelAndView();
		
		int block = 5;
		
		int count = bdao.bCtn();
		System.out.println("게시글 갯수 : " + count);
		
		int maxPage = (int) Math.ceil((double) count /limit);
		
		int startRow = (page - 1) * limit + 1;
		
		int endRow = page * limit;
		
		int startPage = ((int) Math.ceil((double) page / block) - 1) * block + 1;
		
		int endPage = startPage + block -1;
		
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
		
		System.out.println("paging 확인 : " + paging);
		
		List<Boards> boardList = bdao.bList(paging);
		mav.setViewName("board/list");
		mav.addObject("boardList", boardList);
		mav.addObject("paging", paging);

		return mav;
	}

	public ModelAndView bSearch(Search search) {
	    mav = new ModelAndView();
	    
	    List <Boards> searchList = bdao.bSearch(search);
	    
	    mav.addObject("boardList", searchList);
	    mav.setViewName("board/list");
	return mav;
	}

	public ModelAndView modifyForm(int bNum) {
		System.out.println("[2]controller → service : " + bNum);

		mav = new ModelAndView();

		Boards board = bdao.bView(bNum);
		System.out.println("[4]dao → service : " + board);

		mav.addObject("modify", board);
		mav.setViewName("board/modify");

		return mav;
	}
	}

