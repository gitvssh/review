package dataStructure.chapter4;

import java.util.Scanner;

class Node{
	int data;
	Node next;
}

public class C4LinkedRead {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node head=null;
		Node tail=null;
		Node cur=null;
		
		int readData;
		
		while(true)
		{
			System.out.println("자연수 입력");
			readData = sc.nextInt();
			if(readData<1) {
				break;
			}
			
			Node newNode = new Node();
			newNode.data = readData;
			newNode.next = null;
			
			tail = new Node();
			if(head==null) {
				head = newNode;
			}else if(head.next==null){
				head.next=newNode;
			}
			else {
				tail.next = newNode;
			}
			tail=newNode;
		}//end while
		System.out.println();
		
		System.out.println("입력 받은 데이터의 전체출력!");
		if(head==null) {
			System.out.println("저장된 자연수가 존재하지 않습니다.");
		}
		else {
			cur=head;
			System.out.println(cur.data);
			
			while(cur.next!=null) {
				cur=cur.next;
				System.out.println(cur.data);
			}
		}
		
		System.out.println();
		System.out.println();
		
		if(head==null) {
		}
		else {
			Node delNode = head;
			Node delNextNode = head.next;
			
			System.out.println(head.data+"을(를) 삭제합니다.");
			
			while(delNextNode != null) {
				delNode=delNextNode;
				delNextNode=delNextNode.next;
				
				System.out.println(delNode.data+"을(를) 삭제합니다.");
				
			}
		}
	}//end main
}//end class
