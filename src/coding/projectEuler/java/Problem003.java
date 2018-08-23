package coding.projectEuler.java;

import java.util.ArrayList;
import java.util.Iterator;

public class Problem003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		The prime factors of 13195 are 5, 7, 13 and 29.
//
//		What is the largest prime factor of the number 600851475143 ?
		double j = Math.floor(600851475143L);
		double i = Math.floor(1);
		
		for(i=1;i<j;i++) {
			if(j%i==0) {
				System.out.println(i);
			}
			
		}
		
	}
// 소수구하기, int, double연산, 성능이슈->개선방법, 
}
