package com.park.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.park.board.BoardPageASC;
import com.park.dao.BoardCountDAO;
import com.park.dao.BoardListDAO;
import com.park.vo.BoardListVO;
 
@Service
public class BoardListService {
 
    @Inject
    private BoardListDAO dao;
    
    @Inject
    private BoardCountDAO boardcount;
    
    
    
    public BoardListVO boardList(int page) throws Exception {
    	
    	int count = boardcount.boardCount("com.park.mapper.memberMapper.selectBoardCount"); 
    	
    	BoardPageASC boardpage = new BoardPageASC(count,10, page);
 
    	
    	int start_record = boardpage.getStart_record();	
 
    	BoardListVO listVo = new BoardListVO();
    	listVo.setList(dao.boardList(start_record));
    	listVo.setPage(boardpage);
         //
    	
    	return listVo;
    }
  
}
