package boardre;

import java.sql.*;//connection, statement, preparedstatement, resultset
import java.util.*;//vector, list<-arraylist

public class BoardDao {

	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306/mydb";
	String USER="root";
	String PWD="12345";
	
	public BoardDao(){
		try{
			Class.forName(DRIVER);
			//System.out.println("드라이버 로딩 성공");
		}catch(ClassNotFoundException ex){
			System.out.println("드라이버 로딩 실패:"+ex);
		}
	}
	
	private Connection getCon(){
		Connection con=null;
		try{
			con=DriverManager.getConnection(URL,USER,PWD);
			//System.out.println("DB연결 성공");
		}catch(Exception ex){
			System.out.println("DB연결 실패:"+ex);
		}
		return con;
	}
	
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql="";
	
	public void upPos(){
		Connection con=null;
		try{
			con=getCon();
			stmt=con.createStatement();
			sql="update board set pos=pos+1;";
			stmt.executeUpdate(sql);
		}catch(Exception ex1){
			System.out.println("upPose() 예외 :"+ex1);
		}finally{
			try{
				if(stmt!=null){stmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){
				
			}
		}
	}//upPose()
	
	public void insertBoard(BoardDto dto){
		upPos();
		
		Connection con=null;
		
		try{
			con=getCon();
			sql="insert into board (name,email,homepage,subject,content,pos,depth,regdate,pass,ip)"
					+" values(?,?,?,?,?,?,?,NOW(),?,?);";
			//mysql
			//NOW() : 년월일 시분초
			//CURDATE) : 년월일
			
			//oracle
			//sysdate
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getHomepage());
			pstmt.setString(4, dto.getSubject());
			pstmt.setString(5, dto.getContent());
			
			pstmt.setInt(6, dto.getPos());
			pstmt.setInt(7, dto.getDepth());
			//날짜
			pstmt.setString(8, dto.getPass());
			pstmt.setString(9, dto.getIp());
			
			pstmt.executeUpdate();
		}catch(Exception ex1){
			System.out.println("insert 글쓰기 :"+ex1);
		}finally{
			try{
				if(stmt!=null){stmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){
				
			}
		}
	}//insertBoard()
	
	public Vector getBoardList(String keyField, String keyWord){
		
		System.out.println("keyword :"+keyWord);
		Vector vec=new Vector();
		Connection con=null;
		sql="";
		try{
			con=getCon();
			stmt=con.createStatement();
			
			if(keyWord.equals(null)||keyWord.equals("")||keyWord.length()<0){
				sql="select * from board order by pos asc";
				
			}else{
				sql="select * from board where "+keyField+" like '%"+keyWord+"%'"
						+" order by pos asc";
				
			}
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				BoardDto dto=new BoardDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				
				dto.setHomepage(rs.getString("homepage"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				
				dto.setPos(rs.getInt("pos"));
				dto.setDepth(rs.getInt("depth"));
				dto.setRegdate(rs.getString("regdate"));
				
				dto.setPass(rs.getString("pass"));
				dto.setCount(rs.getInt("count"));
				dto.setIp(rs.getString("ip"));
				
				vec.add(dto);
			}
			
		}catch(Exception ex1){
			System.out.println("List 예외 :"+ex1);
			
		}finally{
			
			try{
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){
				
			}
			
		}
		return vec;
	}//getBoardList()
	
	public void upCount(int num){
		Connection con=null;
		try{
			con=getCon();
			sql="update board set count=count+1 where num="+num;
			pstmt=con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(Exception ex1){
			System.out.println("조회수 증가:"+ex1);
		}finally{
			try{
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception ex2){
				
			}
		}
	}//upCount()
	
	//글내용보기, 글수정
	public BoardDto getBoard(int num){
		BoardDto dto=new BoardDto();
		Connection con=null;
		
		try{
			con=getCon();
			String sql="select * from board where num="+num;
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setHomepage(rs.getString("homepage"));
				dto.setSubject(rs.getString("subject"));
				
				dto.setContent(rs.getString("content"));
				dto.setPos(rs.getInt("pos"));
				dto.setDepth(rs.getInt("depth"));
				
				dto.setRegdate(rs.getString("regdate"));
				dto.setPass(rs.getString("pass"));
				dto.setCount(rs.getInt("count"));
				dto.setIp(rs.getString("ip"));
			}//while
			
		}catch(Exception ex1){
			System.out.println("글내용보기, 글수정 :"+ex1);
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){pstmt.close();}
			}catch(Exception ex2){}
		}
		return dto;
	}//getBoard()
}
