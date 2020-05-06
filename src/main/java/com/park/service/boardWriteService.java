package com.park.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.dao.boardWriteDAO;
import com.park.vo.FileBean;
import com.park.vo.boardBean;


@Service
public class boardWriteService {
	
   
	@Autowired
    private boardWriteDAO dao;	

    public int boardWriteService(boardBean board) throws Exception {
    	
    	int seq = dao.boardMaxSeq();
    	
    	board.setNewSeq(seq); 
    	
    	
    	if(null != board.getLocal_file_name() && !board.getLocal_file_name().isEmpty()) {
    		for(String localFileName : board.getLocal_file_name()) {
    			FileBean filebean = new FileBean();
    			
    			filebean.setLocal_file_name(localFileName);
    			filebean.setBoard_seq(seq);
    			
    			int result = dao.updateFileSeqUpdate(filebean);
    			if(result == 0) {
    				
    			}
    		}
    	}
    	
    	    	
        return dao.boardWriteDAO(board);
        
        //fileSeqUpdate
    }
}
