package algorithms;

import java.util.Scanner;

public class Util {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(true)
		{
		System.out.println(countDivisors(scan.nextInt()));
		}
	}
	
	/**
	 * estimate 'is num prime'<br><br>
	 * 
	 * Time Complexity : O(sqrt(n))<br>
	 * Space Complexity : O(1)
	 * @author SH Lee
	 * @param num
	 * @return boolean : 'is num prime?'
	 */
	static boolean isPrime(long num){
		if(num==1)
			return false;
		else if(num<4)
			return true;
		else if(num%2==0)
			return false;
		else if(num<9)
			return true;
		else if(num%3==0)
			return false;
		else{
			int r = (int)Math.sqrt(num);
			int f = 5;
			while(f<=r){
				if(num%f==0)
					return false;
				if(num%(f+2)==0)
					return false;
				f+=6;
			}
		}
		return true;
	}//isPrime
	
	/**
	 * 
	 * 
	 * Time Complexity : O(sqrt(n))<br>
	 * Space Complexity : O(1)
	 * @author SH Lee
	 * @param num
	 * @return
	 */
	static int countDivisors(long num){
		int result = 0;
		for(int i=1;i<=Math.sqrt(num);i++){
			if(num%i==0){
				if(num/i==i){
					result++;
				}else{
					result+=2;
				}
			}
		}
		return result;
	}
}
