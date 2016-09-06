package Algorithms;

import java.io.*;
import java.util.*;

public class BeautifulPairs {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner reader = new Scanner(System.in);
		    int n = reader.nextInt();
		    int[] A = new int[n];
		    int[] B = new int[n];
		    for(int i=0; i< n; i++){
		    	A[i] = reader.nextInt();
		    }
		    for(int i=0; i< n; i++){
		    	B[i] = reader.nextInt();
		    }
		    //logic
		    int count=0;
		    for(int i=0; i< n; i++){
		    	for(int j=0; j< n; j++){
			    	if(A[i] == B[j]){
			    		B[j]=-1;
			    		count++;
			    	}
			    }
		    }
		    if(count == n)
		    	System.out.println(count-1);
		    if(count < n)
		    	System.out.println(count+1);
	        
    }
}