package javareview.util;

import java.util.Calendar;

public class Test03_Calendar {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH);
		int day=cal.get(Calendar.DATE);
				
		int h=cal.get(Calendar.HOUR);
		int m=cal.get(Calendar.MINUTE);
		int s=cal.get(Calendar.SECOND);
		
		System.out.println(year+"년"+month+"월"+day+"일");
		System.out.println(h+":"+m+":"+s);
	}

}
