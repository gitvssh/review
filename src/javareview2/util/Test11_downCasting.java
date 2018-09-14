package javareview2.util;
//����Ŭ����
class Super2{
	//����� ���� �޼��� 
	public void disp(){
		System.out.println("Super2.disp()");
	}
}//class---------

//�Ļ�Ŭ����
class Sub2 extends Super2{
	//�������̵�
	public void disp(){
		System.out.println("Sub2.disp()");
	}
	
	//����� ���� �޼���
	public void aa(){
		System.out.println("Sub2.aa()");
	}
}//class------------------

public class Test11_downCasting {
	public static void main(String args[]){
		Super2 s=new Super2();
		s.disp();
		//
		s=new Sub2();
		s.disp();
		//
		//s.aa(); //����
		((Sub2)s).aa();//downcasting
		//���� int a=(int)12.5;
		
	}//main---
}//class---
