package com.park.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.park.dao.CmmFileDAO;
import com.park.vo.FileBean;


@Service
public class FileUploadService {
	
	private final String path = "C:/park-workspace/Park_ajax/src/main/webapp/upload/";
	
	@Autowired
    private CmmFileDAO dao;
	
    public List<String> fileUpload(List<MultipartFile> fileList) throws Exception {
    	
        int result = 0;
    	List<String> param_local_file_name = new ArrayList<String>();
        
        File fileDir = new File(path);
        
        if (!fileDir.exists()) {
        	fileDir.mkdirs();
        }
        
        long time = System.currentTimeMillis();
        
        for (MultipartFile mf : fileList) {
        	
        	FileBean filebean = new FileBean();        
        	String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            String saveFileName = String.format("%d_%s", time, originFileName);
            filebean.setOrg_file_name(originFileName);
            filebean.setLocal_file_name(saveFileName);
            param_local_file_name.add(saveFileName);
            
            try {
            	// 파일생성
                mf.transferTo(new File(path, saveFileName));    	
                result = dao.fileInsert(filebean);
            } catch (Exception e) {
                e.printStackTrace();
            }
       }    	
   	 
        return param_local_file_name;
    }	

}
