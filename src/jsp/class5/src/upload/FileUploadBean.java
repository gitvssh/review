package upload;

import java.io.*;

import javax.servlet.http.*;

import com.oreilly.servlet.*;//cos.jar
import com.oreilly.servlet.multipart.*;//cos.jar

public class FileUploadBean {

	public String upload(HttpServletRequest request){
		String reply="";
		
		try{
//			MultipartRequest multi=new MultipartRequest(request,"C:\\_java\\aaupload\\");
			String path="c:\\_java\\aaupload\\";
			
			MultipartRequest multi=new MultipartRequest(request,path,5*1024*1024,"utf-8",new DefaultFileRenamePolicy());
			
			reply="파일 업로드 성공";
		}catch(Exception e){
			reply="파일 업로드 실패:"+e;
		}
		
		return reply;
	}
}//class
