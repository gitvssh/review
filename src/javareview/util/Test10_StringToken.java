package javareview.util;

import java.util.StringTokenizer;

public class Test10_StringToken {
	//StringTokenizer 클래스 사용하여 문자열 파싱
	public static void main(String[] args){
		StringTokenizer st = new StringTokenizer("하야시|노연정|1","|");
		
		System.out.println("파싱된 문자열 갯수 :"+st.countTokens());	
		
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
		
		StringTokenizer st2 = new StringTokenizer("서울시 서대문구 창천동");
		while(st2.hasMoreTokens()){
			System.out.println(st2.nextToken());
		}
		System.out.println();
		
		String str = "서울시:마포구:대흥동";
		String temp[] = str.split(":");
		
		for(int i=0;i<temp.length;i++){
			System.out.println(temp[i]);
		}
		
	}
}
