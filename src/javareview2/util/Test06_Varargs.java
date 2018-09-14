package javareview2.util;

public class Test06_Varargs {
	
	public void strPrint(String ...names){
		for(String s:names){
			System.out.println(s+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		Test06_Varargs t = new Test06_Varargs();
		t.strPrint("kim");
		t.strPrint("aaa","bbb","ccc");
		t.strPrint("홍길동","이순신","박문수","아이유","정해인");
	}
}
