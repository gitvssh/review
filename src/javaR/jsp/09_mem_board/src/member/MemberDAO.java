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
//	/**
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
//	
//	/**
//	 * 회원정보 수정
//	 * throws Exception
//	 */
//	public MemberDTO getMember(String id) throws Exception{
//		MemberDTO dto=null;
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		
//		try{
//			con=getCon();
//			pstmt=con.prepareStatement("select * from member where id='"+id+"'");
//			rs=pstmt.executeQuery();
//			
//			if(rs.next()){
//				dto=new MemberDTO();
//				
//				dto.setId(rs.getString("id"));
//				dto.setPasswd(rs.getString("passwd"));
//				dto.setName(rs.getString("name"));
//				
//				dto.setJumin1(rs.getString("jumin1"));
//				dto.setJumin2(rs.getString("jumin2"));
//				dto.setEmail(rs.getString("email"));
//				
//				dto.setZipcode(rs.getString("zipcode"));
//				dto.setAddr(rs.getString("addr"));
//				
//				dto.setJob(rs.getString("job"));
//				dto.setRegdate(rs.getTimestamp("regdate"));
//			}
//		}catch(Exception ex1){
//			System.out.println("getMember 예외:"+ex1);
//		}finally{
//			try{
//				if(rs!=null){rs.close();}
//				if(pstmt!=null){pstmt.close();}
//				if(con!=null){con.close();}
//						
//				
//			}catch(Exception ex2){}
//		}//tcf
//		
//		return dto;
//	}//getMember
//	
//	/**
//	 * 회원정보수정
//	 * throws Exception
//	 */
//	public void updateMember(MemberDTO dto) throws Exception{
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		String sql="";
//		try{
//			con=getCon();
//			sql="update member set passwd=?,name=?,email=?,zipcode=?,addr=?,job=? where id=?";
//			
//			pstmt=con.prepareStatement(sql);
//			
//			pstmt.setString(1, dto.getPasswd());
//			pstmt.setString(2, dto.getName());
//			pstmt.setString(3, dto.getEmail());
//			pstmt.setString(4,dto.getZipcode());
//			pstmt.setString(5, dto.getAddr());
//			pstmt.setString(6, dto.getJob());
//			pstmt.setString(7, dto.getId());
//			
//			pstmt.executeUpdate();
//		}catch(Exception ex1){
//			System.out.println("updateMember 예외:"+ex1);
//		}finally{
//			try{
//				if(pstmt!=null){pstmt.close();}
//				if(con!=null){con.close();}
//			}catch(Exception ex2){}
//		}
//	}//updateMember()
//	
//	/**
//	 * 회원탈퇴
//	 * throws Exception
//	 */
//	public int deleteMember(String id,String passwd) throws Exception{
//		Connection con=null;
//		PreparedStatement pstmt=null,pstmt2=null;
//		ResultSet rs=null;
//		
//		String dbPasswd="";
//		int x=-1;
//		
//		try{
//			con=getCon();
//			pstmt=con.prepareStatement("select passwd from member where id=?");
//			pstmt.setString(1, id);
//			rs=pstmt.executeQuery();
//			
//			if(rs.next()){
//				dbPasswd=rs.getString("passwd");
//				if(passwd.equals(dbPasswd)){
//					pstmt2=con.prepareStatement("delete from member where id=?");
//					pstmt2.setString(1,id);
//					pstmt2.executeUpdate();
//					x=1;
//				}else{
//				}
//			}else{
//				x=0;
//			}
//		}catch(Exception ex1){
//			System.out.println("dleteMember 예외:"+ex1);
//		}finally{
//			try{
//				if(rs!=null){rs.close();}
//				if(pstmt!=null){pstmt.close();}
//				if(pstmt2!=null){pstmt2.close();}
//				if(con!=null){con.close();}
//			}catch(Exception ex2){}
//		}
//		
//		return x;
//	}//deleteMember()
//}//class
