package com.park.dao;

import java.util.List;

import com.park.vo.MemberVO;
 
public interface MemberDAO {
	public List<MemberVO> selectMember() throws Exception;

}
 
