package com.park.dao;



import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.park.vo.FileBean;
import com.park.vo.boardBean;
 
@Repository
public class BoardReadDAO{
 
    @Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.park.mapper.memberMapper.selectBoard";
    
  
    public boardBean boardRead(int seq) throws Exception {
 
        return sqlSession.selectOne(Namespace, seq);
    }
    
    
    public List<FileBean> fileSelect(int seq) throws Exception {
    
    	return sqlSession.selectList("com.park.mapper.memberMapper.cmmfileSelect",seq);
    }
    
 
}

