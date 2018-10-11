//package shopdb;
//
//import java.sql.*;
//
//import java.util.*;
//import javax.sql.*;
//import javax.naming.*;
//
//import com.oreilly.servlet.*;
//import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
//import javax.servlet.http.*;
//import java.io.*;
//
//public class ProductMgr {
//
//		private ProductMgr(){
//			
//		}
//		private static ProductMgr dao=new ProductMgr();
//		
//		public static ProductMgr getDao(){
//			return dao;
//		}
//		
//		//커넥션 풀 사용
//		private Connection getCon() throws Exception{
//			Context ct=new InitialContext();
//			DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
//			return ds.getConnection();
//		}
//		
//		//상품목록 리스트
//		public List getGoodList() throws Exception{
//			
//			String sql="";
//			Connection con=null;
//			Statement stmt=null;
//			ResultSet rs=null;
//			
//			List<ProductDto> goodList=new ArrayList<ProductDto>();
//			
//			try{
//				con=getCon();
//				
//				sql="select * from shop_info";
//				stmt=con.createStatement();
//				rs=stmt.executeQuery(sql);
//				
//				while(rs.next()){
//					ProductDto dto=new ProductDto();
//					
//					dto.setPro_no(rs.getInt("pro_no"));
//					dto.setCode(rs.getString("code"));
//					dto.setName(rs.getString("name"));
//					
//					dto.setPrice(rs.getInt("price"));
//					dto.setStock(rs.getInt("stock"));
//					dto.setDetail(rs.getString("detail"));
//					dto.setComp(rs.getString("comp"));
//					
//					dto.setRegdate(rs.getTimestamp("regdate"));
//					dto.setImage(rs.getString("image"));
//					
//					goodList.add(dto);
//				}
//			}catch(Exception ex1){
//				System.out.println("getGoodList 에러 :"+ex1);
//			}finally{
//				try{
//					if(rs!=null){rs.close();}
//					if(stmt!=null){stmt.close();}
//					if(con!=null){con.close();}
//				}catch(Exception ex2){
//					
//				}
//			}
//			
//			return goodList;
//		}//getGoodList
//		
//		//상세보기
//		public ProductDto getDetails(String code) throws Exception{
//			Connection con=null;
//			Statement stmt=null;
//			ResultSet rs=null;
//			String sql="";
//			ProductDto dto=new ProductDto();
//			
//			try{
//				con=getCon();
//				stmt=con.createStatement();
//				sql="select * from shop_info where code='"+code+"'";
//				rs=stmt.executeQuery(sql);
//				
//				while(rs.next()){
//					dto.setPro_no(rs.getInt("pro_no"));
//					dto.setCode(rs.getString("code"));
//					dto.setName(rs.getString("name"));
//					dto.setPrice(rs.getInt("price"));
//					dto.setStock(rs.getInt("stock"));
//					dto.setDetail(rs.getString("detail"));
//					dto.setComp(rs.getString("comp"));
//					
//					dto.setRegdate(rs.getTimestamp("regdate"));
//					dto.setImage(rs.getString("image"));
//				}
//			}catch(Exception ex1){
//				System.out.println("getDetail 에러 :"+ex1);
//			}finally{
//				try{
//					if(rs!=null){rs.close();}
//					if(stmt!=null){stmt.close();}
//					if(con!=null){con.close();}
//				}catch(Exception ex2){
//					
//				}
//			}
//			
//			return dto;
//		}//getDetails()
//		
//		//pro_no 정보 : 상품일련번호, update에서 사용
//		public ProductDto getProduct(String code,int pro_no){
//			Connection con=null;
//			PreparedStatement pstmt=null;
//			ResultSet rs=null;
//			
//			ProductDto dto=null;
//			String sql=null;
//			
//			try{
//				con=getCon();
//				sql="select * from shop_info where pro_no=?";
//				pstmt=con.prepareStatement(sql);
//				pstmt.setInt(1, pro_no);
//				rs=pstmt.executeQuery();
//				
//				while(rs.next()){
//					dto=new ProductDto();
//					
//					dto.setPro_no(rs.getInt("pro_no"));
//					dto.setCode(rs.getString("code"));
//					dto.setName(rs.getString("name"));
//					
//					dto.setPrice(rs.getInt("price"));
//					dto.setStock(rs.getInt("stock"));
//					dto.setDetail(rs.getString("detail"));
//					
//					dto.setComp(rs.getString("comp"));
//					dto.setRegdate(rs.getTimestamp("regdate"));
//					dto.setImage(rs.getString("image"));
//				}
//			}catch(Exception ex1){
//				System.out.println("getProduct 에러:"+ex1);
//			}finally{
//				try{
//					if(rs!=null){rs.close();}
//					if(pstmt!=null){pstmt.close();}
//					if(con!=null){pstmt.close();}
//				}catch(Exception ex2){
//					
//				}
//			}
//			return dto;
//		}//getProduct
//		
//		//남은물량 계산하기
//		public void reduceProduct(OrderDto order){
//			Connection con=null;
//			PreparedStatement pstmt=null;
//			
//			try{
//				con=getCon();
//				String sql="update shop_info set stock=(stock-?) where pro_no=?";
//				pstmt=con.prepareStatement(sql);
//				
//				pstmt.setString(1,order.getQuantity());
//				pstmt.setInt(2, order.getPro_no());
//				pstmt.executeUpdate();
//			}catch(Exception ex1){
//				System.out.println("reduceProduct 에러:"+ex1);
//			}finally{
//				try{
//					if(pstmt!=null){pstmt.close();}
//					if(con!=null){con.close();}
//				}catch(Exception ex2){
//					
//				}
//			}
//		}//reduceProduct()
//		
//		
//		//---------------------------관리자----------------------------
//		//상품등록
//		//import javax.servlet.http.*;
//		//import com.oreilly.servlet.*;
//		//import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
//		public boolean insertProduct(HttpServletRequest req){
//			Connection con=null;
//			PreparedStatement pstmt=null;
//			boolean result=false;
//			
//			//JSP경우 : 실제경로얻기 : 그림등록하기 위해
//			//<%= config.getServletContext().getRealPath("/")%>
//			//<%= application.getRealPath("/")%>
//			
//			//서블릿에서 실제 경로 얻기 : 그림등록하기 위해
//			//request.getRealPath("/")
//			//request.getServletContext().getRealPath("/");=>이것이 더 정확함
//			
//			//jsp 웹 경로 얻기 : 그림을 갖와 웹으로 출력할때
//			//<%=request.getContextPath()%>
//			//=>프로젝트 이름이 컨텍스트 이름이다.
//			
//			try{
//				con=getCon();
//				String real_path=req.getServletContext().getRealPath("/");
//				String upload_Dir=real_path+"/imgs/";
//				
//				//cos.jar 사용, 파일업로드
//				//파일 업로드는 객체생성시 업로드 된다.
//				MultipartRequest multi=new MultipartRequest(req,upload_Dir,5*1024*1024,"utf-8",new DefaultFileRenamePolicy());
//				
//				String sql="";
//				sql="insert into shop_info(pro_no,name,code,price,stock,detail,comp,"
//						+"regdate,image) values(0,?,?,?,?,?,?,NOW(),?)";
//				pstmt=con.prepareStatement(sql);
//				
//				pstmt.setString(1,multi.getParameter("name"));
//				pstmt.setString(2,multi.getParameter("code"));
//				pstmt.setInt(3,Integer.parseInt(multi.getParameter("price")));
//				pstmt.setInt(4, Integer.parseInt(multi.getParameter("stock")));
//				
//				pstmt.setString(5,multi.getParameter("detail"));
//				pstmt.setString(6, multi.getParameter("comp"));
//				
//				if(multi.getFilesystemName("image")!=null){//그림파일이 잇을때
//					pstmt.setString(7, multi.getFilesystemName("image"));
//				}else{//그림파일이 없을때
//					pstmt.setString(7, "ready.gif");
//				}
//				
//				int count=pstmt.executeUpdate();
//				
//				if(count==1){//insert가 되었으면
//					result=true;
//				}
//				
//			}catch(Exception ex1){
//				System.out.println("insertProduct 에러"+ex1);
//			}finally{
//				try{
//					if(pstmt!=null){pstmt.close();}
//					if(con!=null){con.close();}
//				}catch(Exception ex2){
//					
//				}
//			}//tcf
//			
//			return result;
//		}//insertProduct()
//		
//
//		//상품업데이트
//		public boolean updateProduct(HttpServletRequest req){
//			Connection con=null;
//			PreparedStatement pstmt=null;
//			boolean result=false;
//			String sql="";
//			
//			try{
//				con=getCon();
//				String real_path=req.getServletContext().getRealPath("/");
//				String upload_Dir=real_path+"/imgs/";
//				int size=5*1024*1024;
//				
//				//그림 올리기(파일업로드)
//				MultipartRequest multi=new MultipartRequest(req,upload_Dir,size,"utf-8",new DefaultFileRenamePolicy());
//				
//				if(multi.getFilesystemName("image")==null){//그림파일이 없으면
//					sql="update shop_info set name=?,stock=?,detail=?,price=?,code=?,comp=? where pro_no=?";
//					
//					pstmt=con.prepareStatement(sql);
//					
//					pstmt.setString(1, multi.getParameter("name"));
//					pstmt.setInt(2,Integer.parseInt(multi.getParameter("stock")));
//					pstmt.setString(3, multi.getParameter("detail"));
//					
//					pstmt.setInt(4,Integer.parseInt(multi.getParameter("price")));
//					pstmt.setString(5,multi.getParameter("code"));
//					pstmt.setString(6, multi.getParameter("comp"));
//					
//					pstmt.setInt(7,Integer.parseInt(multi.getParameter("pro_no")));
//				}else{//그림파일이 있으면
//					//먼저 그림파일을 삭제한다
//					int im=Integer.parseInt(multi.getParameter("pro_no"));
//					String sql2="select image from shop_info where pro_no="+im;
//					
//					Statement stmt=con.createStatement();
//					ResultSet rs=stmt.executeQuery(sql2);
//					
//					if(rs.next()){//이미지가 존재하면
//						//String image=rs.getString("image");
//						//File f=new File(upload_Dir+image);
//						File f=new File(upload_Dir+rs.getString("image"));
//						if(f.isFile()){
//							f.delete();
//						}
//					}
//					
//					rs.close();
//					stmt.close();
//					
//					//update 구문 작성
//					sql="update shop_info set name=?,stock=?,detail=?,"
//							+"price=?,code=?,comp=?,image=? where pro_no=?";
//					pstmt=con.prepareStatement(sql);
//					
//					pstmt.setString(1, multi.getParameter("name"));
//					pstmt.setInt(2,Integer.parseInt(multi.getParameter("stock")));
//					pstmt.setString(3, multi.getParameter("detail"));
//					
//					pstmt.setInt(4, Integer.parseInt(multi.getParameter("price")));
//					pstmt.setString(5,multi.getParameter("code"));
//					pstmt.setString(6, multi.getParameter("comp"));
//					
//					pstmt.setString(7,multi.getFilesystemName("image"));
//					pstmt.setInt(8, Integer.parseInt(multi.getParameter("pro_no")));
//				}
//				
//				int count=pstmt.executeUpdate();
//				if(count==1){
//					result=true;
//				}
//				
//			}catch(Exception ex1){
//				System.out.println("updateProduct 에러"+ex1);
//			}finally{
//				try{
//					if(pstmt!=null){pstmt.close();}
//					if(con!=null){con.close();}
//				}catch(Exception ex2){
//					
//				}
//			}
//			
//			return result;
//		}//updateProduct
//		
//		//행=row=record 삭제
//		//그림파일 삭제
//		
//		public boolean deleteProduct(HttpServletRequest req,int pro_no){
//			
//			Connection con=null;
//			PreparedStatement pstmt=null;
//			boolean result=false;
//			
//			try{
//				con=getCon();
//				
//				String sql2="select image from shop_info where pro_no="+pro_no;
//				String real_path=req.getServletContext().getRealPath("/");
//				String upload_Dir=real_path+"imgs/";
//				
//				Statement stmt=con.createStatement();
//				ResultSet rs=stmt.executeQuery(sql2);
//				
//				if(rs.next()){
//					File f=new File(upload_Dir+rs.getString("image"));
//					if(f.isFile()){
//						f.delete();
//					}
//				}
//				
//				rs.close();
//				stmt.close();
//				
//				//db shop_info 테이블 레코드 삭제
//				String sql="delete from shop_info where pro_no=?";
//				pstmt=con.prepareStatement(sql);
//				pstmt.setInt(1,pro_no);
//				int count=pstmt.executeUpdate();
//				
//				if(count>0){
//					result=true;
//				}
//			}catch(Exception ex1){
//				System.out.println("deleteProduct 에러"+ex1);
//			}finally{
//				try{
//					if(pstmt!=null){pstmt.close();}
//					if(con!=null){con.close();}
//				}catch(Exception ex2){
//					
//				}
//			}//tcf
//			return result;
//		}//deleteProduct
//}
