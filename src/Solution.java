import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        sc.nextLine();
        sc.useDelimiter(" ");
        int n = Integer.parseInt(sc.next());
        int anna = Integer.parseInt(sc.next());
        
        int[] meal = new int[n];
        sc.nextLine();
        int i=0;
        while(sc.hasNext()){
            meal[i] = Integer.parseInt(sc.next());
        }
        //end Input
        
        int sum = 0;
        int actual = 0;
        int charged = 0;
        for(int j=0;j<n;j++){
            if(j==anna){
                continue;
            }
            sum += meal[j];
        }
        actual = sum/2;
        charged = (sum+meal[anna])/2;
        if(actual==charged){
            System.out.println("Bon Appetit");
        }else{
            System.out.println(charged-actual);
        }
    }
}