package javaR.util;
import java.util.Enumeration;
import java.util.Properties;
import javaR.util.*;

public class Test12_Properties {
	
	public static void main(String[] args){
		Properties pro = new Properties();
		
		pro.put("driver", "com.mysql.jdbc.Driver");
		pro.put("url","jdbc:mysql://localhost:3306/mydb");
		pro.put("user","root");
		pro.put("pwd", "12345");
		
		String driver=pro.getProperty("driver");
		String url=pro.getProperty("url");
		String user=pro.getProperty("user");
		String pwd=pro.getProperty("pwd");
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(user);
		System.out.println(pwd);
		
		Enumeration en  = pro.propertyNames();
		
		while(en.hasMoreElements()){
			String key=(String)en.nextElement();
			String val=pro.getProperty(key);
			System.out.println(val);
		}
	}
}
