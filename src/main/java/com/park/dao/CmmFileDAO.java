package com.park.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.park.vo.FileBean;

@Repository
public class CmmFileDAO {
	@Autowired
	private SqlSession sqlSession;
    private static final String Namespace = "com.park.mapper.memberMapper";
    private int RetrunValue;
    
    public int fileInsert(FileBean file) throws Exception {
   	 
    	    	
   		RetrunValue = sqlSession.insert("com.park.mapper.memberMapper.cmmFileInsert", file);
    		

    	
    	return RetrunValue;
    }
    
}
