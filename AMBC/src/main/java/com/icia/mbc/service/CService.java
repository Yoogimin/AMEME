package com.icia.mbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.mbc.dao.CDao;
import com.icia.mbc.dto.Comments;

@Service
public class CService {
     @Autowired
     private CDao cdao;
     
	public List<Comments> cList(int cbNum) {
		System.out.println("[2] cbNum : " + cbNum);
		List<Comments> list = cdao.cList(cbNum);
		System.out.println("[4] list : " + list);
		return list;
	}

	public List<Comments> cWrite(Comments comment) {
		try {
			cdao.cWrite(comment);
		} catch(Exception e) {
			e.printStackTrace();
	    }
		List<Comments> list = cdao.cList(comment.getCbNum());
		
		return list;
	}

	public List<Comments> cModify(Comments comment) {
		
		try {
			cdao.cModify(comment);
		} catch(Exception e) {
			e.printStackTrace();
		}
		List<Comments> list = cdao.cList(comment.getCbNum());
		return list;
	}

	public List<Comments> cDelete(Comments comment) {
		try {
			cdao.cDelete(comment);
		} catch(Exception e) {
			e.printStackTrace();
		}
		List<Comments> list = cdao.cList(comment.getCbNum());
		return list;
	}

}
