//package model;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
////DTO
//public class Board {
//
//	private int num;
//	private String writer;
//	private String subject;
//	private String email;
//	
//	private String content;
//	private String pwd;
//	private Date wdate;
//	private int readcount;
//	private String ip;
//	
//	public Board(){
//		
//	}
//
//	public Board(int num, String writer, String subject, String email,
//			String content, String pwd, Date wdate, int readcount, String ip) {
//		super();
//		this.num = num;
//		this.writer = writer;
//		this.subject = subject;
//		this.email = email;
//		this.content = content;
//		this.pwd = pwd;
//		this.wdate = wdate;
//		this.readcount = readcount;
//		this.ip = ip;
//	}
//
//	public int getNum() {
//		return num;
//	}
//
//	public void setNum(int num) {
//		this.num = num;
//	}
//
//	public String getWriter() {
//		return writer;
//	}
//
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//
//	public String getSubject() {
//		return subject;
//	}
//
//	public void setSubject(String subject) {
//		this.subject = subject;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public String getPwd() {
//		return pwd;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//
//	public Date getWdate() {
//		return wdate;
//	}
//
//	public void setWdate(Date wdate) {
//		this.wdate = wdate;
//	}
//
//	public int getReadcount() {
//		return readcount;
//	}
//
//	public void setReadcount(int readcount) {
//		this.readcount = readcount;
//	}
//
//	public String getIp() {
//		return ip;
//	}
//
//	public void setIp(String ip) {
//		this.ip = ip;
//	}
//	
//	public String toString(){
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		String result;
//		result=String.format("[글쓴이=%s,글제목=%s,글내용=%s,날짜=%s,ip=%s]", writer,subject,content,sdf.format(wdate),ip);
//		return result;
//	}
//	
//}
