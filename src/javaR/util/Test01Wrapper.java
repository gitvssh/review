package javaR.util;

public class Test01Wrapper {

	public static void main(String[] args) {
		boolean b=true;//�Ϲ��ڷ���
		Boolean B = new Boolean(b);//��ü����
		
		int a=30;
		Integer A = new Integer(a);

		double d = 12.5;
		Double D = new Double(d);
		
		System.out.println("Wrapper class value : "+B.toString());
		System.out.println("Wrapper class value : "+A.toString());
		System.out.println("Wrapper class value : "+D.toString());
		
		int a1=10;
		Integer A1=a1;
		int b1=A1;
	}

}
