package java.util2;
//����Ŭ����
class PanMae3{
	protected String pum;
	protected int su;
	protected int dan;
	
	public PanMae3(){}
	public PanMae3(String pum,int su,int dan){
		this.pum=pum;
		this.su=su;
		this.dan=dan;
	}
	
	//����� ���� �޼���
	public void disp(){
		System.out.println("\npum:"+pum);
		System.out.println("su:"+su);
		System.out.println("dan:"+dan);
	}
}//class--------------------------

//�Ļ�Ŭ���� 
class SalePanMae3 extends PanMae3{
	private double rate;//������
	
	public SalePanMae3(){}
	public SalePanMae3(String pum,int su,int dan, double rate){
		super(pum,su,dan);
		this.rate=rate;
	}
	//�������̵�
	public void disp(){
		System.out.println("\npum:"+pum);
		System.out.println("su:"+su);
		System.out.println("dan:"+dan);
	}
	//����� ���� �޼��� 
	public void halInAk(){
		System.out.println("���ξ�:"+(dan*rate));
	}
}//class---------------------------
public class Test12_downCasting {
	public static void main(String[] args) {
		
		PanMae3 p[]=new PanMae3[4];//�迭����
		
		p[0]=new PanMae3("�����",3,5000);
		p[1]=new SalePanMae3("������",5,7000,0.1);
		p[2]=new PanMae3("�ε�ī��",2,9000);
		p[3]=new SalePanMae3("������",7,9000,0.2);
		
		for(int i=0;i<p.length; i++){
			p[i].disp();
			 
			//p[i].halInAk();
			if(p[i] instanceof SalePanMae3){
				((SalePanMae3)p[i]).halInAk();
			}
			
		}//for
	}//main---
}//class------------
