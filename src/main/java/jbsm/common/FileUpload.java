package jbsm.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.UUID;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
@MultipartConfig
public class FileUpload {

	public String FileUpload(Part filePart) throws Exception {
		
		String fileName = "";
		
		try {
			
			System.out.println("컨텐츠 확인 (마임 타입) : " + filePart.getContentType()); 
	        System.out.println("바이트 기반 파일 크기 : " + filePart.getSize());
	        System.out.println("업로드된 파일 이름 : " + filePart.getSubmittedFileName());
	        
	        InputStream fileContent = filePart.getInputStream();
	 
	        OutputStream outputStream = null;
	        
	        try {

	        	String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(System.currentTimeMillis());
	            UUID uuid = UUID.randomUUID();
	            fileName = timeStamp + "_" + filePart.getSubmittedFileName(); 
	            
	            String saveDirectory = "D:/JBSM_IMG/upload";
	            File dir = new File(saveDirectory);
	 
	            if (!dir.exists()) {
	                dir.mkdirs();
	            }
	            
	            File file = new File("D:/JBSM_IMG/upload/", fileName);
	            
	            outputStream = new FileOutputStream(file);
	            byte[] buffer = new byte[1024];
	            int length;
	            while ((length = fileContent.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, length); 
	            }
	            
	        } catch (Exception e) {
	            
	        } finally {
	        	
	            outputStream.flush();
	 
	            if (outputStream != null) {
	                outputStream.close();
	            }
	            fileContent.close();
	        }
	        
		} catch (IOException e) {
		
			e.printStackTrace();
		}

		return fileName;
	}
}
