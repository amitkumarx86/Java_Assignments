package Algorithms;

import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner reader = new Scanner(System.in);
        int t = reader.nextInt();
        reader.nextLine();
        for(int i=0;i<t;i++){
            
            String s = reader.nextLine();
            System.out.println(Check(s));
        }
    }
    public static String Check(String s){
        String reverse = new StringBuffer(s).reverse().toString();
	    	String flag = "Funny";
	        for(int i=1;i < s.length();i++){
	            if(!((Math.abs((int)s.charAt(i) - (int) s.charAt(i-1))) == (Math.abs((int)reverse.charAt(i) - (int) reverse.charAt(i-1))))){
	            	flag = "Not Funny";
	            	break;
	            }
	        }
			return flag;
    }
}