package com.icia.mbc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mbc.dto.Comments;

@Repository
public class CDao {

	@Autowired
	private SqlSessionTemplate sql;

	public List<Comments> cList(int cbNum) {
		System.out.println("[3] cbNum : " + cbNum);
		return sql.selectList("Comment.cList", cbNum);
	}

	public void cWrite(Comments comment) {
		System.out.println("[3] cbNum : " + comment);
		sql.insert("Comment.cWrite", comment);

	}

	public void cModify(Comments comment) {
		System.out.println("[3] cbNum : " + comment);
		sql.update("Comment.cModify",comment);

	}

	public void cDelete(Comments comment) {
		System.out.println("[3] cbNum : " + comment);
	    sql.delete("Comment.cDelete", comment);
	}
}
