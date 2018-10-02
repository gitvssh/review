//package mail;
//
//import java.io.*;
//import com.oreilly.servlet.*;
//
//public class MailSender {
//	private String from;//보내는사람 이메일 주소
//	private String to;//받는사람 이메일 주소
//	private String subject;//제목
//	private String content;//내용
//	
//	public MailSender(){//생성자
//		from="";
//		to="";
//		subject="";
//		content="";
//	}
//
//	public void setFrom(String from) {
//		this.from = from;
//	}
//
//	public void setTo(String to) {
//		this.to = to;
//	}
//
//	public void setSubject(String subject) {
//		this.subject = subject;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//	
//	//기타메서드
//	public String send(){
//		String reply="";
//		try{
//			MailMessage msg=new MailMessage("smtp.nate.com");
//			msg.from(from);
//			msg.to(to);
//			msg.setSubject(subject);
//			
//			PrintStream out=msg.getPrintStream();
//			out.println(content);
//			
//			//출력용 스트림의 내용을보내고 종료
//			msg.sendAndClose();
//			
//			reply="메일 전송 성공";
//		}catch(Exception ex){
//			reply="메일 전송 실패 :"+ex;
//		}
//		return reply;
//	}
//	
//}
