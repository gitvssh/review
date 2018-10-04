package boardmysql;

import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;

//비지니스 로직
public class BoardDAO {
	
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getDao(){
		return dao;
	}
	
	private BoardDAO(){
		
	}
	
	//커넥션 얻기
	private Connection getCon() throws Exception{
		Context ct=new InitialContext();
		DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		return ds.getConnection();
	}
	
	//원글,답글쓰기
	public void insertArticle(BoardDTO dto) throws Exception{
		
		int num=dto.getNum();
		int ref=dto.getRef();
		int re_step=dto.getRe_step();
		int re_level=dto.getRe_level();
		
		int number=0;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="";
		
		try{
			con=getCon();
			pstmt=con.prepareStatement("select max(num) from board");//최대 글번호 얻기
			rs=pstmt.executeQuery();
			
			if(rs.next()){//글이 존재하면
				number=rs.getInt(1)+1;//최대글번호+1(글 그룹)
			}else{//글이 없을때, 첫번째 글일때
				number=1;//ref=number  첫번째 글일때 글 그룹
			}
			
			if(num!=0){//num이 있으면=글번호가 있으면, 답글이면
				//답글 끼워넣기 위치 확보
				sql="update board set re_step=re_step+1 where ref=? and re_step>?";
				
				pstmt=con.prepareStatement(sql);
				//값 채우기
				pstmt.setInt(1, ref);;
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				
				re_step+=1;//글 순서증가
				re_level+=1;//글 깊이증가
				
			}else{//원글
				ref=number;//글 그룹번호 할당, 현재 글 번호를 ref에 넣는다.
				re_step=0;
				re_level=0;
			}
			
			sql="insert into board (writer,email,subject,passwd,regdate,ref,re_step,re_level,content,ip)"
					+" values(?,?,?,?,NOW(),?,?,?,?,?)";
			
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4,dto.getPasswd());
			//날짜
			pstmt.setInt(5,ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7, re_level);
			pstmt.setString(8, dto.getContent());
			pstmt.setString(9, dto.getIp());
			
			pstmt.executeUpdate();
		}catch(Exception ex1){
			System.out.println("insertAritlce 에러:"+ex1);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){
				
			}
		}//tcf
	}//insertArticle()
	
	/**
	 * 글 개수
	 * throws Exception
	 */
	public int getArticleCount() throws Exception{
		int cnt=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=getCon();
			
			pstmt=con.prepareStatement("select count(*) from board");
			rs=pstmt.executeQuery();
					
			if(rs.next()){
				cnt=rs.getInt(1);
			}
		}catch(Exception ex1){
			System.out.println("getArticleCount() 예외 : "+ex1);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){
				
			}
		}//tcf
		
		return cnt;
	}//getArticleCount()
	
	/**
	 * 리스트
	 * 
	 */
	public List getList(int start,int cnt) throws Exception{
		
		List<BoardDTO> list=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="";
		
		try{
			con=getCon();
			sql="select * from board order by ref desc,re_step asc limit ?,?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, cnt);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				list=new ArrayList<BoardDTO>();
				do{
					BoardDTO dto=new BoardDTO();
					
					dto.setNum(rs.getInt("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setEmail(rs.getString("email"));
					dto.setSubject(rs.getString("subject"));
					dto.setPasswd(rs.getString("passwd"));
					
					dto.setRegdate(rs.getDate("regdate"));
//					System.out.println("날짜 " +rs.getDate("regdate"));
//					System.out.println("날짜 " +rs.getString("regdate"));
//					System.out.println("날짜 " +rs.getTimestamp("regdate"));
					
					dto.setReadcount(rs.getInt("readcount"));
					
					dto.setRef(rs.getInt("ref"));
					dto.setRe_step(rs.getInt("re_step"));
					dto.setRe_level(rs.getInt("re_level"));
					
					dto.setContent(rs.getString("content"));
					dto.setIp(rs.getString("ip"));
					
					list.add(dto);
				}while(rs.next());
			}
		}catch(Exception ex1){
			System.out.println("getList 예외 :"+ex1);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){
				
			}
		}
		return list;
	}//getList()
}
