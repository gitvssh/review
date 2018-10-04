//package member;
//
//import java.sql.*;
//import java.util.Vector;
//import javax.sql.*;//DataSource
//import javax.naming.*;//lookup
//
////DAO 비지니스 로직
//public class MemberDAO {
//	//싱글톤 객체 사용, 객체를 하나만 사용하도록 한다. 메모리 절약이 된다.
//	private static MemberDAO instance=new MemberDAO();
//	
//	//JSP에서 객체를 얻을때는 : LoginDao.getInstance()
//	public static MemberDAO getInstance(){
//		return instance;
//	}
//	
//	//디폴트 생성자, 외부에서 객체생성 못함, <jsp:useBean>도 사용 못함
//	private MemberDAO(){
//		
//	}
//	
//	/**
//	 * 커넥션 풀 사용 메서드
//	 * throws Exception
//	 */
//	private Connection getCon() throws Exception{
//		Context ct=new InitialContext();
//		DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
//		return ds.getConnection();
//	}
//	
//	/**
//	 * id 중복체크
//	 * throws Exception 
//	 */
//	public int confirmId(String id) throws Exception{
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		int x=-1;
//		
//		try{
//			con=getCon();
//			pstmt=con.prepareStatement("select id from member where id=?");
//			pstmt.setString(1,id);
//			rs=pstmt.executeQuery();
//			
//			if(rs.next()){//사용중인 id
//				x=1;
//			}else{
//				x=-1;
//			}
//		}catch(Exception ex1){
//			System.out.println("confimID 예외 :"+ex1);
//		}finally{
//			try{
//				if(rs!=null){rs.close();}
//				if(pstmt!=null){pstmt.close();}
//				if(con!=null){con.close();}
//			}catch(Exception ex2){}
//		}//tcf
//		
//		return x;
//	}//confirmId
//	
//	/*
//	 * 회원가입
//	 * throws Exception
//	 */
//	public void insertMember(MemberDTO dto) throws Exception{
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		
//		try{
//			con=getCon();
//			pstmt=con.prepareStatement("insert into member values(?,?,?,?,?,?,?,?,?,?)");
//			
//			pstmt.setString(1,dto.getId());
//			pstmt.setString(2,dto.getPasswd());
//			pstmt.setString(3,dto.getName());
//			pstmt.setString(4,dto.getJumin1());
//			pstmt.setString(5,dto.getJumin2());
//			pstmt.setString(6,dto.getEmail());
//			pstmt.setString(7,dto.getZipcode());
//			pstmt.setString(8,dto.getAddr());
//			pstmt.setString(9,dto.getJob());
//			pstmt.setTimestamp(10,dto.getRegdate());
//			
//			pstmt.executeUpdate();
//		}catch(Exception ex1){
//			System.out.println("InsertMember:"+ex1);
//		}finally{
//			try{
//				if(pstmt!=null){pstmt.close();}
//				if(con!=null){con.close();}
//			}catch(Exception ex2){}
//		}//tcf
//	}//insertMember()
//	
//	public int userCheck(String id, String passwd) throws Exception{
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		String dbPwd="";
//		int x=-1;
//		
//		try{
//			con=getCon();
//			pstmt=con.prepareStatement("select * from member where id=?");
//			pstmt.setString(1,id);
//			rs=pstmt.executeQuery();
//			
//			if(rs.next()){
//				dbPwd=rs.getString("passwd");
//				
//				if(passwd.equals(dbPwd)){
//					x=1;//인증 성공
//				}else{
//					x=0;//암호 틀림
//				}
//			}else{
//				x=-1;//해당 아이디 없음
//			}
//		}catch(Exception ex1){
//			System.out.println("userCheck() 예외:"+ex1);
//		}finally{
//			try{
//				if(rs!=null){rs.close();}
//				if(pstmt!=null){pstmt.close();}
//				if(con!=null){con.close();}
//			}catch(Exception ex2){}
//		}
//		
//		return x;
//	}//userCheck()
//}//class
