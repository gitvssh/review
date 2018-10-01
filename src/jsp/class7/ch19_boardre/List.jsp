<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardre.*"
    import="java.util.*"
    %>
<%
request.setCharacterEncoding("utf-8");
%>    

<%
int nowPage=0;//현재 페이지
int nowBlock=0;//현재 블럭

int totalRecord=0;//전체 글 갯수
int numPerPage=10;//페이지당 글 갯수, 1 페이지에 10개씩
int totalPage=0;//전체 페이지 수

int totalBlock=0;//전체블럭수
int pagePerBlock=10;//블럭당 페이지 수 10개
int beginPerPage=0;//시작 페이지(페이지의 시작)

String keyField="";//키 필드
String keyWord="";//검색 단어
Vector<BoardDto> vec=null;
%>

<%
String im=request.getParameter("keyWord");

if(request.getParameter("keyWord")!=null){
	//검색어가 있으면
	keyWord=request.getParameter("keyWord");
	keyField=request.getParameter("keyField");
}

if(request.getParameter("reload")!=null){
	//전체리스트
	if(request.getParameter("reload").equals("true")){
		keyWord="";
		keyField="";
		
	}
}
%>

<%
boardre.BoardDao dao=new boardre.BoardDao();//객체생성
vec=dao.getBoardList(keyField,keyWord);//dao메서드 호출

totalRecord=vec.size();

if(request.getParameter("page")!=null){
	nowPage=Integer.parseInt(request.getParameter("page"));//현제 페이지
}

beginPerPage=nowPage*numPerPage;//시작페이지 계산

//0*10=0   0~9;  해당페이지의 시작
//1*10=10 10~19
//2*10=20 20~29
//3*10=30 30~39
//4*10=40 40~49

//예 글 개수 32개라면 4개의 페이지가 나옴
//4=int Math.ceil(32/10);
totalPage=(int)Math.ceil((double)totalRecord/numPerPage);
totalBlock=(int)Math.ceil((double)totalPage/pagePerBlock);//전체 블럭 계산

if(request.getParameter("nowBlock")!=null){
	nowBlock=Integer.parseInt(request.getParameter("nowBlock"));//현재 블럭을 얻는다.
}
%>

<html>
<head>
<script type="text/javascript">
function check(){
	if(document.searchForm.keyWord.value==''){
		alert("검색어를 입력하세요");
		document.searchForm.keyWord.focus();
		return false;
	}
	document.searchForm.submit();
}

function list(){
	document.listForm.action="List.jsp";
	document.listForm.submit();
}

function read(value){
	document.readForm.action="Read.jsp";
	document.readForm.num.value=value;
	document.readForm.submit();
}
</script>
<body bgcolor="ivory">
	<table align="center" border=0 width="80%">
		<tr>
			<td align="left">
			Total:<%=totalRecord %>Article&nbsp;
			(<font color=blue><%=nowPage+1 %>/<%=totalPage %></font>)
			</td>
		</tr>
	</table>
	
	<table align="center" width="80%" border=1 cellspacing=0 cellpadding=3>
		<tr>
			<td align=center colspan=2>
			<%
			if(vec.isEmpty()){
				out.println("등록된 글이 없습니다.");
			}else{
				%>
				<table border=1 width="100%" cellpadding=2 cellspacing=0>
					<tr align=center bgcolor="#d0d0d0" height="120%">
						<td>번호</td>
						<td>제목</td>
						<td>이름</td>
						<td>날짜</td>
						<td>조회수</td>
					</tr>
					<%
					// beginPerPage+10
					for(int i=beginPerPage;i<(beginPerPage+numPerPage);i++){
						if(i==totalRecord){break;}
						BoardDto dto=(BoardDto)vec.get(i);
						
						String name=dto.getName();
						String subject=dto.getSubject();
						String email=dto.getEmail();
						String regdate=dto.getRegdate();
						
						int depth=dto.getDepth();
						int num=dto.getNum();
						int count=dto.getCount();
						%>
						<tr>
							<!-- 번호를 역순으로, num와 다른다 -->
							<td align=center><%=totalRecord-i %></td>
							
							<!-- 글제목, 글제목을 클릭하면 글내용보기로 간다 -->
							<td>
							<%
							//답글 체크해서 들여쓰기 
							if(depth>0){//답글이면
								for(int re=0;re<depth;re++){
									out.println("&nbsp;&nbsp;");
								}//for
							}//if
							%>
							<a href="javascript:read('<%=num %>')">
								<%=subject %>
							</a>
							</td>
							
							<td align=center>
							<a href="mailto:<%=email %>">
								<%=name %>
							</a>
							</td>
							<td align=center><%=regdate %></td>
							<td align=center><%=count %></td>
						</tr>
						<%
					}//for
					%>
				</table>
				<%
			
			%>
		</tr>
		
		<tr>
			<td><br></td>
		</tr>
		
		<tr>
			<td align=left>Go to Page
			<%
			if(totalRecord!=0){
				if(nowBlock>0){
					%>
					<a href="list.jsp?nowBlock=<%=nowBlock-1 %>&page=<%=((nowBlock-1)*pagePerBlock+9) %>&keyField=<%=keyField %>&keyWord=<%=keyWord %>">
					[이전블럭 <%=pagePerBlock %>]개
					</a>
					<%
				}//if(nowBlock>0)
			}//if(totalRecord!=0)
				
			%>
			
			<%
			//---페이지 처리------
			for(int i=0;i<pagePerBlock;i++){
			%>
				<a href="List.jsp?nowBlock<%=nowBlock %>&page=<%=(nowBlock*pagePerBlock)+i %>">
					[<%=(nowBlock*pagePerBlock)+i+1 %>]
				</a>
			<%
				if(((nowBlock*pagePerBlock)+i+1)==totalPage){
					break;
				}//if
			
			}//for
			//--------------페이지처리 끝--------------------
			
			//다음 블럭 처리
			if(totalBlock>nowBlock+1){
			%>
				<a href="list.jsp?nowBlock=<%=nowBlock+1 %>&page=<%=(nowBlock+1)*pagePerBlock %>&keyField=<%=keyField %>">			
					[다음블럭]<%=pagePerBlock %>]개
				</a>			
			<%
			}//다음블럭 if end
			
			}//if(vec.isEmpty)~else
			%>
			</td>
			
			<td align=right>
				<a href="Post.jsp">[글쓰기]</a>
				<a href="javascript:list()">[리스트 처음으로]</a>
			</td>
		</tr>
	</table>
	
	<%-- searchForm --%>
	<form name="searchForm" method="post" action="List.jsp">
		<table bgcolor="ivory" width="80%" border=1 align=center cellpadding=4 cellspacing=0>
			<tr>
				<td align=center valign=bottom>
					<select name="keyField">
						<option value="subject">제목</option>
						<option value="name">이름</option>
						<option value="content">글내용</option>
					</select>
					
					<input type="text" name="keyWord" size=16>
					<input type="hidden" name="page" value="0">
					<input type="button" value="찾기" onClick="check()">
					
				</td>
			</tr>
		</table>
	</form>
	
	<%--listForm 자바스크립트를 함께 사용 --%>
	
	<form name="listForm" method="post">
		<input type="hidden" name="reload" value="true">
		<input type="hidden" name="page" value="0">
		<input type="hidden" name="nowBlock" value="0">
	</form>
	
	<%--readForm 자바스크립트를 함께 사용 --%>
	<form name="readForm" method="post">
		<!-- num값은 javaScript에서 넣었음 -->
		<input type="hidden" name="num" value="">
		
		<input type="hidden" name="page" value="<%=nowPage %>">
		<input type="hidden" name="keyField" value="<%=keyField %>">
		<input type="hidden" name="keyWord" value="<%=keyWord %>">
	</form>
</body>
</head>
</html>