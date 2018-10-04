package javaR.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javaR.util.*;

public class Test04_Calendar {
	public static void main(String[] args){
		GregorianCalendar gc = new GregorianCalendar();
		
		if(gc.isLeapYear(1988)){
			System.out.println("1988년은 윤년");
		}else{
			System.out.println(gc.get(Calendar.YEAR)+"는 평년");
		}
		
		Calendar cal = Calendar.getInstance();
		
		System.out.println("올해의 "+cal.get(Calendar.WEEK_OF_YEAR)+"주 입니다.");
		System.out.println("올해의 "+cal.get(Calendar.DAY_OF_YEAR)+"일 입니다.");
	}//end main
}
