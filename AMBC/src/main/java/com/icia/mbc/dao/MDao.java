package com.icia.mbc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mbc.dto.Members;
import com.icia.mbc.dto.Paging;
import com.icia.mbc.dto.Search;

@Repository
public class MDao {
    @Autowired
    private SqlSessionTemplate sql;
    
	public String idcheck(String mId) {
		
		return sql.selectOne("Member.idCheck", mId);
	}

	public void mJoin(Members member) {
		sql.insert("Member.mJoin", member);
		
	}

	public Members mView(String mId) {
	   
		return sql.selectOne("Member.mView",mId);
	}

	public List<Members> mList(Paging paging) {
		return sql.selectList("Member.mList", paging);
	}

	public int mCount() {
		return sql.selectOne("Member.mCount");
	}

	public void mModify(Members member) {
		sql.update("Member.mModify", member);
	}
	
	public void mDelete(String mId) {
		sql.delete("Member.mDelete", mId);
	}

	public List<Members> mSearch(Search search) {
		return sql.selectList("Member.mSearch", search);
	
	}

}
