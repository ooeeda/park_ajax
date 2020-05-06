package com.park.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.park.dao.BoardReadDAO;
import com.park.vo.FileBean;
import com.park.vo.boardBean;
 
@Service
public class BoardReadService {
 
    @Inject
    private BoardReadDAO dao;
 
    public boardBean boardRead(int seq) throws Exception {
 
        return dao.boardRead(seq);
    }
    
    public List<FileBean> selectBoardFile(int seq) throws Exception {
    	
    	return dao.fileSelect(seq);
    }
 
}
