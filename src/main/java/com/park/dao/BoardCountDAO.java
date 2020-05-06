package com.park.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardCountDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	public int boardCount(String namespace) throws Exception{
		
		
		return sqlSession.selectOne(namespace);
	}
	

}
