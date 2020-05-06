package com.park.vo;

import java.util.List;

import com.park.board.BoardPageASC;

public class BoardListVO {

	private List<boardBean> list;
	
	private BoardPageASC page;

	public List<boardBean> getList() {
		return list;
	}

	public void setList(List<boardBean> list) {
		this.list = list;
	}

	public BoardPageASC getPage() {
		return page;
	}

	public void setPage(BoardPageASC page) {
		this.page = page;
	}
}
