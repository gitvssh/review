package java.util;

public class Test15_Object_clone implements Cloneable{
	
	String myName;
	
	public Test15_Object_clone(String name){
		this.myName = name;
	}
	
	public String toString(){
		return myName+" 입니다";
	}
	
	public static void main(String[] args){
		try{
			Test15_Object_clone A1 = new Test15_Object_clone("홍길동");
			System.out.println(A1);
			System.out.println(A1.toString());
			
			Double D = new Double(11.2);
			System.out.println(D);
			System.out.println(D.toString());
			
			Test15_Object_clone ob2=(Test15_Object_clone)A1.clone();
			System.out.println("ob2:"+ob2.toString());
			System.out.println("A1:"+A1.toString());
		}catch(Exception ex){
			System.out.println("예외 +"+ex);
		}
	}
}
