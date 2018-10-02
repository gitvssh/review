//package emailupload;
//
//import java.io.*;
//import javax.servlet.http.*;
//import com.oreilly.servlet.*;
//import com.oreilly.servlet.multipart.*;
//
//public class EmailUpload {
//	
//	public String upload(HttpServletRequest request){
//		String reply="";
//		
//		try{
//			MultipartRequest m=new MultipartRequest(request,"c:\\_java\\aaupload\\",1024*1024*5,"utf-8",new DefaultFileRenamePolicy());
//			
//			String from=m.getParameter("from");
//			String to=m.getParameter("to");
//			String subject=m.getParameter("subject");
//			String content=m.getParameter("content");
//			
//			MailMessage msg=new MailMessage("smtp.nate.com");
//			
//			msg.from(from);
//			msg.to(to);
//			msg.setSubject(subject);
//			
//			//mailMessage에서 출력용 스트림생성
//			PrintStream out=msg.getPrintStream();//출력스트림 생성
//			out.println(content);
//			msg.sendAndClose();
//			
//			reply="메일보내기, 파일업로드 성공";
//			
//		}catch(Exception ex){
//			reply="메일보내기 실패";
//		}
//		
//		return reply;
//	}
//
//}
