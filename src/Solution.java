import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        
        sc.useDelimiter(" ");
        sc.nextLine();
        int n = Integer.parseInt(sc.next());
        int s = Integer.parseInt(sc.next());//handle first line input 
        int[] testCase = new int[n];
        int anna = 0;
        int sum = 0;
        int i = 0;
        sc.useDelimiter(" ");
        sc.nextLine();
        
        while(sc.hasNext()){
         testCase[i++]= Integer.parseInt(sc.next());
        }//handle seconde line input
        
        anna = sc.nextInt();//handel third line input
        
        for(int j=0;j<n;j++){
            if(i==anna){
                continue;
            }else{
                sum+= testCase[i];
            }
        }//end for
        
        int result = (sum+testCase[anna])/2-sum/2;
        
        if(sum+testCase[anna]/2==sum/2){
            System.out.println("Bon Appetit");
        }else{
            System.out.println(result);
        }
    
    }//end main
}//end class