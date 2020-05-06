package com.park.myapp;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.park.service.BoardReadService;
import com.park.vo.FileBean;
import com.park.vo.boardBean;

@Controller
public class BoardWrite {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @Inject
    private BoardReadService service;
    
    @RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
    public String boardWrite(Locale locale, Model model) throws Exception{
 
        logger.info("boardWrite");
        


 
        return "/WEB-INF/views/boardWrite";
    }
    
    @ResponseBody
    @RequestMapping(value="/selectBoardWrite", method = RequestMethod.GET)
    public JSONObject selectBoardWrite(@RequestParam("seq") int seq) throws Exception {
    	
    	JSONObject jo = new JSONObject();
    	boardBean board = service.boardRead(seq); 
    	
        if(seq > 0 ) {
    		 
        	List<FileBean> fileList = service.selectBoardFile(seq);
    		jo.put("board",board);
    		jo.put("fileList", fileList);
        } 
    	
    	
    	return jo;
    }
	
}
