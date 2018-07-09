package hacckerRank_PS;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenPractice {

    public static void main(String[] args) {
    	String s = "Good luck with this case!!! h jrkjc c l m e i vct h ss pqk_v i olf tuoej_          p r jrpjpuo a.   ";
        StringTokenizer a = new StringTokenizer(s," !,?_'@");
        
        int countTokens = a.countTokens();
        System.out.println(countTokens);
        for(int i=0;i<countTokens;i++){
            System.out.println(a.nextToken());
        }
    
        
        
    }

}
