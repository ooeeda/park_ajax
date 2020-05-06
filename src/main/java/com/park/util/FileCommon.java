package com.park.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/*************************************************************************************
 * <pre>
 * 웹에서 사용하는 파일처리 클래스
 * 
 * 주요기능
 * 1. 파일업로드
 * 2. 파일이동(reNameTo 실패할 경우가 있음(윈도우 서버에서 reNameTo만 사용할 경우 문제)) -- 미구현
 * 3. 파일복사후 파일삭제처리
 * 4. 파일삭제
 * 5. 디렉터리생성 
 * </pre>
 * @author 박수환
 * @since 2012-09-26 
 * @version 1.0
 **************************************************************************************/
public class FileCommon {
	
	private static final int UploadSize = 1024*4; 
	
	private static String source, dest;	
	private static final Logger logger = LoggerFactory.getLogger(FileCommon.class);
	
		
	public FileCommon() {}
	
	/**********************************************************************************
	 * 파일 파일이동시(복사후삭제) 사용하는 생성자
	 * @param source -  파일원본파일경로 ex)etc/a.text
	 * @param dest   -  대상파일경로     ex)etc2/a.text
	 **********************************************************************************/
	public FileCommon(String source, String dest) {
		
		this.source = source;
		this.dest   = dest;		
		
	}
	
	/**********************************************************************************
	 * @param UploadFilePath - 업로드 파일경로와 파일명
	 * @param formFile       - 로컬 form에서 넘어온 FormFile객체
	 **********************************************************************************/
/*	public boolean FileUpload(String UploadFilePath, FormFile formFile) {
		// 파일 업로드용 전체경로
		File file = new File(UploadFilePath);

		// 파일 업로드용 스트림
		InputStream in = null;
		OutputStream os = null;
		int j = 0;
		
		
		try {
			
			os = new FileOutputStream(file);
			in = formFile.getInputStream();
			
			// 파일업로드
			byte [] buffer = new byte[UploadSize];
			
			while ((j = in.read()) != -1) {
				os.write(j);
			}
			
			logger.info("파일업로드 성공 ["+UploadFilePath+"]");	
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
			logger.info("파일업로드 실패 ["+e.getMessage()+"]");	
		} catch (IOException e) {			
			e.printStackTrace();
			logger.info("파일업로드 실패 ["+e.getMessage()+"]");
		}
		
		return true;
	}
*/
	/**********************************************************************************
	 * <pre>
	 * 파일복사후 삭제처리 메서드
	 * 복사후 원본파일 삭제는 처리되지 않을 수 있음
	 * </pre>
	 * 
	 * @return 파일복사 성공여부 
	 **********************************************************************************/
	public boolean CopyFileDelete() {   
	    boolean result = false;   
	           
	    FileInputStream inputStream = null;   
	    FileOutputStream outputStream = null;   
	           
	    try {   
	    	
	    	inputStream = new FileInputStream(source);   
	        outputStream = new FileOutputStream(dest); 
	        
	    } catch (FileNotFoundException e) {   
	    	
	        e.printStackTrace(); 
	        logger.info("파일복사삭제부분["+e.getMessage()+"]");
	        result = false;   
	        
	    }   
	           
	    FileChannel fcin = inputStream.getChannel();   
	    FileChannel fcout = outputStream.getChannel();   
	           
	    long size = 0;   
	    
	    try {   	    	
	    	
	        size = fcin.size();   
	        fcin.transferTo(0, size, fcout);   
	               
	        fcout.close();   
	        fcin.close();   
	        outputStream.close();   
	        inputStream.close();   
               
	        result = true;   
		        
	    } catch (IOException e) {   
	    	
	        e.printStackTrace();   
	        result = false;   
	        
	    }   
	           
	    File f = new File(source);   
	    
	    if (FileDelete(f)) {   
	    	
	        result = true;   	        
	    }   
	    
	    return result;   
	} 
	
	/*****************************************************************************
	 * 디렉토리 생성
	 * 	 
	 * @param dir 생성할 디렉터리 위치
	 * @return 생성이 성공할경우 true, 이미 디렉토리가 존재할 경우 false
	 ******************************************************************************/
	public boolean CreateDirectory(File dir) {
		
		if (dir.exists() == false) {
			
			dir.mkdirs();
			
			return true;
			
		}	
		
		return false;
	}
	
	/*****************************************************************************
	 * 파일 삭제
	 * 
	 ******************************************************************************/
	public boolean FileDelete(File f) {
	    
		if (f.delete()) {
	        System.out.println("파일 삭제성공!");
	        return true;
	    }
		
		System.out.println("파일삭제 실패");
		
		return false;
	}




}
