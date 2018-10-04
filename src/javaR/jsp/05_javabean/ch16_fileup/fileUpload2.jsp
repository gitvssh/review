<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>

<%
request.setCharacterEncoding("UTF-8");

String savePath="c:/_java/aaupload/";
int sizeLimit=5*1024*1024;

try{
	//생성자가 파일 업로드까지 한다.
	MultipartRequest multi=new MultipartRequest(request,savePath,sizeLimit,"utf-8",new DefaultFileRenamePolicy());
	
	//폼안의 전송된 파일 정보를 가져온다.
	Enumeration formNames=multi.getFileNames();
	
	//자료가 많을 경우엔 while문을 사용
	String formName=(String)formNames.nextElement();
	
	//서버에 저장된 파일 이름을 리턴(파일의 이름 얻기)
	String fileName=multi.getFilesystemName(formName);
	
	if(fileName==null){
		out.print("파일 업로드 되지 않았음");
	}else{
		out.print("Name:"+multi.getParameter("name")+"<BR>");
		out.print("ID:"+multi.getParameter("id")+"<BR>");
		out.print("PWD:"+multi.getParameter("pwd")+"<BR>");
		out.print("Form 안의 Name : "+formName+"<br>");
		out.print("File Name : " + fileName);
		
		//input 태그속성이 file인것, //서버에 저장된 파일 이름
		String fileName2=multi.getFilesystemName("upfile");
		
		//전송된 원래 파일 이름
		String original=multi.getOriginalFileName("upfile");
		
		//input 항목이름에 해당하는
		//파일 정보를 file형으로 리턴합니다.
		File file=multi.getFile("upfile");
		
		//전송된 file의 contentType
		String type=multi.getContentType("upfile");
		
		out.print("<br><br>서버에 저장된 파일 이름 :"+fileName2+"<br>");
		out.print("<br><br>전송된 원래 파일 이름 :"+original+"<br>");
		out.print("<br><br>input 항목이름에 해당하는 파일 정보를 File형으로 리턴 :"+file+"<br>");
		out.print("<br><br>전송된 file의 contentType :"+type+"<br>");
		
		if(file!=null){
			out.print("파일 size :"+file.length()+"<br>");
		}
	}
}catch(Exception ex){
	out.println("파일 업로드 예외 :"+ex);
}
%>