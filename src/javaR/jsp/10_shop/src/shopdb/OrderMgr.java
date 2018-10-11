//package shopdb;
//
//import java.sql.*;
//import java.util.Vector;
//import javax.sql.*;
//import javax.naming.*;
//
//public class OrderMgr {
//
//	public OrderMgr(){}
//	
//	public Connection getCon() throws Exception{
//		Context ct=new InitialContext();
//		DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
//		return ds.getConnection();
//	}//getCon()
//	
//	//1. 주문
//	public void insertOrder(OrderDto dto) throws Exception{
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		
//		try{
//			con=getCon();
//			String sql="insert into shop_order(ordno,userid,pro_no,quantity,orddate,state)"
//					+" values(0,?,?,?,NOW(),?)";
//			
//			pstmt=con.prepareStatement(sql);
//			
//			pstmt.setString(1, dto.getUserid());
//			pstmt.setInt(2,dto.getPro_no());
//			pstmt.setString(3,dto.getQuantity());
//			pstmt.setString(4,"1");//상태
//			
////			1 접수중
////			2 접수
////			3 입금확인
////			4 배송준비
////			5 배송중
////			defaul 배송완료
//			
//			pstmt.executeUpdate();
//		}catch(Exception ex1){
//			System.out.println("insertOrder 에러"+ex1);
//		}finally{
//			try{
//				if(pstmt!=null){pstmt.close();}
//				if(con!=null){con.close();}
//			}catch(Exception ex2){
//				
//			}
//		}
//	}//insertOrder()
//	
//	//2.userid 한명의 클라이언트에 해당하는 주문 목록 얻기
//	public Vector<OrderDto> getOrder(String userid){
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		String sql="";
//		Vector<OrderDto> vec=new Vector<OrderDto>();
//		
//		try{
//			con=getCon();
//			sql="select * from shop_order where userid=? order by ordno desc";
//			pstmt=con.prepareStatement(sql);
//			pstmt.setString(1,userid);
//			rs=pstmt.executeQuery();
//			
//			OrderDto dto=null;
//			while(rs.next()){
//				dto=new OrderDto();
//				
//				dto.setUserid(rs.getString("userid"));
//				dto.setQuantity(rs.getString("quantity"));
//				dto.setOrddate(rs.getTimestamp("orddate"));
//				dto.setOrdno(rs.getInt("ordno"));
//				dto.setState(rs.getString("state"));
//				dto.setPro_no(rs.getInt("pro_no"));
//				
//				vec.add(dto);
//			}
//			
//		}catch(Exception ex1){
//			System.out.println("getOrder() 에러"+ex1);
//		}finally{
//			try{
//				if(rs!=null){rs.close();}
//				if(pstmt!=null){pstmt.close();}
//				if(con!=null){con.close();}
//			}catch(Exception ex2){
//				
//			}
//		}
//		return vec;
//	}//getOrder
//	
//	//3.모든 주문정보
//	public Vector getOrderList(){
//		
//		Connection con=null;
//		Statement stmt=null;
//		ResultSet rs=null;
//		Vector<OrderDto> vec=new Vector<OrderDto>();
//		OrderDto dto=null;
//		String sql="";
//		
//		try{
//			con=getCon();
//			sql="select * from shop_order order by ordno desc";
//			stmt=con.createStatement();
//			rs=stmt.executeQuery(sql);
//			
//			while(rs.next()){
//				dto=new OrderDto();
//				
//				dto.setUserid(rs.getString("userid"));
//				dto.setQuantity(rs.getString("quantity"));
//				dto.setOrddate(rs.getTimestamp("orddate"));
//				dto.setOrdno(rs.getInt("ordno"));
//				dto.setState(rs.getString("state"));
//				dto.setPro_no(rs.getInt("pro_no"));
//				
//				vec.add(dto);
//			}
//		}catch(Exception ex1){
//			System.out.println("getOrderList 에러"+ex1);
//		}finally{
//			try{
//				if(rs!=null){rs.close();}
//				if(stmt!=null){stmt.close();}
//				if(con!=null){con.close();}
//			}catch(Exception ex2){
//				
//			}
//		}
//		return vec;
//	}//getOrderList()
//}
