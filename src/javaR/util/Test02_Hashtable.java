package javaR.util;
import java.util.Hashtable;
import javaR.util.*;

public class Test02_Hashtable {

	public static void main(String[] args) {
		Hashtable<String,Object> ht = new Hashtable<String,Object>();
		ht.put("id","kim");
		ht.put("pwd", "1234");
		ht.put("name", "ȫ�浿");
		
		ht.put("number", new Integer(111));
		
		System.out.println("���̵� :"+ht.get("id"));
		System.out.println("psw :"+ht.get("pwd"));
		System.out.println("�̸� :"+ht.get("name"));
		System.out.println("��ȣ :"+ht.get("number"));
		
		System.out.println("ht.size() :"+ht.size());
		System.out.println("numer�� remove "+ht.remove("number"));
		System.out.println("ht.size() : "+ht.size());
		
	}

}
//Hashtable : �˻��� ������(�˻��� �����ϴ�)
//---------------------------------
// key         value
//---------------------------------
//"id"         "kim"
//"pwd"         "12345"
//---------------------------------
//Hashtable �޼���
//Object put(Object key,Object value)  => �ؽ����̺� ����
//Objec get(Object key)=>�ؽ����̺�� ���� ���� ��´�
//Object remove(Object key) => �ؽ����̺��� �� ����
//int size() : �ؽ����̺��� Ű ������ ���Ѵ� 