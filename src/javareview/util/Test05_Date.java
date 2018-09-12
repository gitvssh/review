package javareview.util;

import java.util.*;
import java.text.*;

public class Test05_Date {

	public static void main(String[] args) {
		java.util.Date date = new java.util.Date();
		System.out.println(date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
		System.out.println(sdf2.format(date));
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd H:mm:ss E");
		System.out.println(sdf3.format(date));
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd H:mm:ss EEEE");
		System.out.println(sdf4.format(date));
	}

}
