package com.park.myapp;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.park.service.FileUploadService;
import com.park.service.boardWriteService;
import com.park.vo.boardBean;

@Controller
public class boardWriteInsert {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    //boardWriteService boardInsert = new boardWriteService();
    @Autowired
    private boardWriteService boardInsert;
    
    @ResponseBody
    @RequestMapping(value = "/boardWriteInsert", method = RequestMethod.POST)
    public int boardWriteInsert(boardBean board, HttpServletResponse response) throws Exception{
 
    	
        logger.info("boardWriteInsert");
  /*
        logger.info("name : "+request.getParameter("name"));
        logger.info("memo : "+request.getParameter("memo"));
       
       */
       /* 
        Map parameterMap = new HashMap();
        Enumeration enums = request.getParameterNames();
        while(enums.hasMoreElements()){
	        String paramName = (String)enums.nextElement();
	        String[] parameters = request.getParameterValues(paramName);
        }*/
       
        
        logger.info("name : " + board.getName());
        logger.info("memo : " + board.getMemo());
        
        
       
       // response.sendRedirect("/BoardList?page=1");
        
        return boardInsert.boardWriteService(board);
        
    }

    @Autowired
    private FileUploadService filUpload;
    
    @ResponseBody
    @RequestMapping(value = "/multipartUpload", method = RequestMethod.POST)
    public List<String> multipartUpload(MultipartHttpServletRequest request) throws Exception {
    	logger.info("multipartUpload");
    	
    	List<MultipartFile> fileList = request.getFiles("fileObj"); 
    	       
        
        return filUpload.fileUpload(fileList);
                

    }    
    
}
