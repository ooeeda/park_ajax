package com.park.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.park.vo.FileBean;
import com.park.vo.boardBean;


@Repository
public class boardWriteDAO {
	
	//@Inject
	@Autowired
	private SqlSession sqlSession;
   
	
    private int RetrunValue;
    
    public int boardWriteDAO(boardBean board) throws Exception {
    	 
    	System.out.println("시작");
    	System.out.println("name " + board.getName());
    	System.out.println("memo " + board.getMemo());
    	System.out.println("getSeq " + board.getSeq());
    	
    	
    	if(board.getSeq() > 0 ) {
    		System.out.println("1");
    		RetrunValue = sqlSession.update("com.park.mapper.memberMapper.boardWriteUpdate", board);
    		
    	} else {
    		System.out.println("2");
    		RetrunValue = sqlSession.insert("com.park.mapper.memberMapper.boardWriteInert", board);
    		
    	}
    	
    	
    	
    	
    	
    	return RetrunValue;
    }
    
	public int boardMaxSeq() throws Exception{
		
		
		return sqlSession.selectOne("com.park.mapper.memberMapper.boardMaxSeq");
	}	
	
	public int updateFileSeqUpdate(FileBean file) throws Exception {
		
		return sqlSession.update("com.park.mapper.memberMapper.fileSeqUpdate", file);
	}
    
	
}
