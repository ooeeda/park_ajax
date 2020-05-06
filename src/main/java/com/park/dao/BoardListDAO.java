package com.park.dao;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.park.vo.boardBean;
 
@Repository
public class BoardListDAO{
 
    @Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.park.mapper.memberMapper.selectBoardList";
    
  
    public List<boardBean> boardList(int start_record) throws Exception {
 
        return sqlSession.selectList(Namespace, start_record);
    }


 
}

