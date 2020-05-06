package com.park.myapp;

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

import com.park.service.BoardListService;
import com.park.vo.BoardListVO;

@Controller
public class BoardListController {
	private static final Logger logger = LoggerFactory.getLogger(BoardListController.class);
    @Inject
    private BoardListService service;
	
	@RequestMapping(value="/BoardList", method = RequestMethod.GET)
	public String boardList(Locale locale, Model model) throws Exception {
		
		logger.info("boardList");
		
		//BoardListVO boardList = service.boardList(page);
		//model.addAttribute("boardlist", boardList);
		
		return "/WEB-INF/views/BoardList";
	}
	
	/**
	 * ��� ��������.
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/selectBoardList", method = RequestMethod.GET)
	public JSONObject selectBoardList(@RequestParam("page") int page) throws Exception {
		BoardListVO boardList = service.boardList(page);
		
		JSONObject jo = new JSONObject();
		jo.put("boardlist", boardList);
		
		return jo;
	}
	

}
