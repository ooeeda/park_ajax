package com.park.myapp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
import org.springframework.web.multipart.MultipartFile;

import com.park.service.BoardReadService;
import com.park.vo.FileBean;
import com.park.vo.boardBean;

@Controller
public class BoardReadController {
	private static final Logger logger = LoggerFactory.getLogger(BoardReadController.class);
    @Inject
    private BoardReadService service;
	
    @RequestMapping(value="/BoardRead", method = RequestMethod.GET)
	public String boardList(Locale locale, Model model) throws Exception {
		
		logger.info("boardRead"); 		
		
		//boardBean board = service.boardRead(seq);		
		//model.addAttribute("boardRead", board);
		
		return "/WEB-INF/views/BoardRead";
	}
	
	@ResponseBody
	@RequestMapping(value="/selectBoardRead", method = RequestMethod.GET)
	public JSONObject selectBoardread(@RequestParam("seq") int seq) throws Exception {
		
		
		boardBean board = service.boardRead(seq);
		List<FileBean> fileList = service.selectBoardFile(seq);
		
		JSONObject jo = new JSONObject();
		jo.put("boardRead", board);
		jo.put("fileList", fileList);
		
		
		return jo;
	}
	
	

}
