package coding.hackerRank.problemSolve;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BonAppetit {

    public static void main(String args[] ) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int anna = Integer.parseInt(s[1]);
        
        int[] meal = new int[n];
        String[] f = br.readLine().split(" ");
        
        for(int i=0;i<f.length;i++){
            meal[i] = Integer.parseInt(f[i]);
        
        }
        //end Input
        
        int sum = 0;
        int actual = 0;
        int charged = Integer.parseInt(br.readLine());
        for(int j=0;j<n;j++){
            if(j==anna){
                continue;
            }
            sum += meal[j];
        }
        actual = sum/2;
        if(actual==charged){
            System.out.println("Bon Appetit");
        }else{
            System.out.println(charged-actual);
        }
    }

}
