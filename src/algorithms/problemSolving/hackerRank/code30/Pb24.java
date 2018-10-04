package algorithms.problemSolving.hackerRank.code30;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import javaR.util.*;

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Pb24{
	static void levelOrder(Node root){
	      LinkedList<Node> que = new LinkedList<Node>();
	    que.offer(root);
	    System.out.println(que.isEmpty());
	    while(!que.isEmpty()){
	        Node retData = que.poll();
	        System.out.print(retData.data+" ");
	        if(retData.left!=null)
	            que.offer(retData.left);
	        if(retData.right!=null)
	            que.offer(retData.right);
	    }
	      
	    }

public static Node insert(Node root,int data){
    if(root==null){
        return new Node(data);
    }
    else{
        Node cur;
        if(data<=root.data){
            cur=insert(root.left,data);
            root.left=cur;
        }
        else{
            cur=insert(root.right,data);
            root.right=cur;
        }
        return root;
    }
}
public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }	
}