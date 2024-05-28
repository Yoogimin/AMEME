package com.icia.mbc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mbc.dto.Boards;
import com.icia.mbc.dto.Paging;
import com.icia.mbc.dto.Search;


@Repository
public class BDao {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int bWrite(Boards board) {	
		return sql.insert("Board.bWrite", board);
	}

	public Boards bView(int bNum) {
		return sql.selectOne("Board.bView",bNum);
		
	}

	public int bConut(int bNum) {
		return sql.update("Board.bCount", bNum);
		
	}

	public int bModify(Boards board) {
		return sql.update("Board.bModify",board);
	}

	public int bDelete(int bNum) {
		return sql.delete("Board.bDelete",bNum);
	}

	public int bCtn() {
		
		return sql.selectOne("Board.bCtn");
	}

	public List<Boards> bSearch(Search search) {

		return sql.selectList("Board.bSearch", search);
	}

	public List<Boards> bList(Paging paging) {
		return sql.selectList("Board.bList", paging);
		
	}

	
}
