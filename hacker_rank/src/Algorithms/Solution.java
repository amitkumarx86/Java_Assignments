package Algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
        int n = 7;
        int c[] = {0,0,1,0,0,1,0};
        /*
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        */
        int i=0, index=0, count=0;
        int c1 = 10;
		while(i != n-1 && c1-- > 0){
			System.out.println("After while ="+ index + " " + i);
			if(c[index] == 0){
				if(index+2 < n && c[index+2] == 0){
					count++;
					i = index+2;
		            index = index +2;
		            System.out.println("After +2 "+ index + " " + i);
				}
				else{
					count++;
		            index = index +1;
		            i = index;
		            System.out.println("After +1"+ index + " " + i);
		        }
			}
		}
		System.out.println(count);
    }
}
