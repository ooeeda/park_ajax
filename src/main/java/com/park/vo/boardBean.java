package com.park.vo;

import java.util.List;

public class boardBean {
	private String name;
	private String memo;
	private String pw;
	private int seq;
	private String subject;
	private List<String> local_file_name;
	private int newSeq;
	
	public int getNewSeq() {
		return newSeq;
	}
	public void setNewSeq(int newSeq) {
		this.newSeq = newSeq;
	}
	public List<String> getLocal_file_name() {
		return local_file_name;
	}
	public void setLocal_file_name(List<String> local_file_name) {
		this.local_file_name = local_file_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}	

}
