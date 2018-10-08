package shopdb;

import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.http.*;
import java.io.*;

public class ProductMgr {

		private ProductMgr(){
			
		}
		private static ProductMgr dao=new ProductMgr();
		
		public static ProductMgr getDao(){
			return dao;
		}
		
		//커넥션 풀 사용
		private Connection getCon() throws Exception{
			Context ct=new InitialContext();
			DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
			return ds.getConnection();
		}
		
		//상품목록 리스트
		public List getGoodList() throws Exception{
			
			String sql="";
			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;
			
			List<ProductDto> goodList=new ArrayList<ProductDto>();
			
			try{
				con=getCon();
				
				sql="select * from shop_info";
				stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				
				while(rs.next()){
					ProductDto dto=new ProductDto();
					
					dto.setPro_no(rs.getInt("pro_no"));
					dto.setCode(rs.getString("code"));
					dto.setName(rs.getString("name"));
					
					dto.setPrice(rs.getInt("price"));
					dto.setStock(rs.getInt("stock"));
					dto.setDetail(rs.getString("detail"));
					dto.setComp(rs.getString("comp"));
					
					dto.setRegdate(rs.getTimestamp("regdate"));
					dto.setImage(rs.getString("image"));
					
					goodList.add(dto);
				}
			}catch(Exception ex1){
				System.out.println("getGoodList 에러 :"+ex1);
			}finally{
				try{
					if(rs!=null){rs.close();}
					if(stmt!=null){stmt.close();}
					if(con!=null){con.close();}
				}catch(Exception ex2){
					
				}
			}
			
			return goodList;
		}//getGoodList
		
		//상세보기
		public ProductDto getDetails(String code) throws Exception{
			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;
			String sql="";
			ProductDto dto=new ProductDto();
			
			try{
				con=getCon();
				stmt=con.createStatement();
				sql="select * from shop_info where code='"+code+"'";
				rs=stmt.executeQuery(sql);
				
				while(rs.next()){
					dto.setPro_no(rs.getInt("pro_no"));
					dto.setCode(rs.getString("code"));
					dto.setName(rs.getString("name"));
					dto.setPrice(rs.getInt("price"));
					dto.setStock(rs.getInt("stock"));
					dto.setDetail(rs.getString("detail"));
					dto.setComp(rs.getString("comp"));
					
					dto.setRegdate(rs.getTimestamp("regdate"));
					dto.setImage(rs.getString("image"));
				}
			}catch(Exception ex1){
				System.out.println("getDetail 에러 :"+ex1);
			}finally{
				try{
					if(rs!=null){rs.close();}
					if(stmt!=null){stmt.close();}
					if(con!=null){con.close();}
				}catch(Exception ex2){
					
				}
			}
			
			return dto;
		}//getDetails()
		
		//pro_no 정보 : 상품일련번호, update에서 사용
		public ProductDto getProduct(String code,int pro_no){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			ProductDto dto=null;
			String sql=null;
			
			try{
				con=getCon();
				sql="select * from shop_info where pro_no=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, pro_no);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					dto=new ProductDto();
					
					dto.setPro_no(rs.getInt("pro_no"));
					dto.setCode(rs.getString("code"));
					dto.setName(rs.getString("name"));
					
					dto.setPrice(rs.getInt("price"));
					dto.setStock(rs.getInt("stock"));
					dto.setDetail(rs.getString("detail"));
					
					dto.setComp(rs.getString("comp"));
					dto.setRegdate(rs.getTimestamp("regdate"));
					dto.setImage(rs.getString("image"));
				}
			}catch(Exception ex1){
				System.out.println("getProduct 에러:"+ex1);
			}finally{
				try{
					if(rs!=null){rs.close();}
					if(pstmt!=null){pstmt.close();}
					if(con!=null){pstmt.close();}
				}catch(Exception ex2){
					
				}
			}
			return dto;
		}//getProduct
}
