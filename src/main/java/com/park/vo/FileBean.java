package com.park.vo;

public class FileBean {

	private int seq;
	private String org_file_name;
	private String local_file_name;
	private String save_time;
	private int board_seq;
	
	
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getOrg_file_name() {
		return org_file_name;
	}
	public void setOrg_file_name(String org_file_name) {
		this.org_file_name = org_file_name;
	}
	public String getLocal_file_name() {
		return local_file_name;
	}
	public void setLocal_file_name(String local_file_name) {
		this.local_file_name = local_file_name;
	}
	public String getSave_time() {
		return save_time;
	}
	public void setSave_time(String save_time) {
		this.save_time = save_time;
	}
	
	
	
	
	
	
}
