package learn_java;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution_xor {

	public static void main(String[] args) {
		/* 
		 * Enter your code here. Read input from STDIN. 
		 * Print output to STDOUT. Your class should be named Solution. 
		 * */
		
		Scanner reader = new Scanner(System.in);
		int inputString = reader.nextInt();
		
		
		
		Map<Integer, Integer> arrFreq = new HashMap<Integer, Integer>();
		
		int n = reader.nextInt();
		int arr[]=new int[n];
		System.out.println(n);
		for(int i=0;i<n;i++){//for reading array
		    int temp=reader.nextInt();
		    arr[i]=temp;
		    
		    if (!arrFreq.containsValue(temp)){
		        arrFreq.put(temp,1);    
		    }
		    else
		        arrFreq.put(temp,arrFreq.get(temp)+1);    
		    
		}
		
		System.out.println(", frequencies:"+ freq(arrFreq));
		
		
		for(int i=0;i<n;i++){
		    int temp = 0;
		    while(temp<=n){
		        int result=0;
		        if(i==0) System.out.println(arr[i] + ", frequencies:"+ freq(arrFreq));
		        else{
		            for (int j=0; j<i; j++){
		              result = result + arr[temp+j];    
		            } 
		            temp=temp+1;
		        }
		        // increase freq
		        if (!arrFreq.containsValue(result)){
		        arrFreq.put(result,1);    
		        }
		        else
		        arrFreq.put(result,arrFreq.get(result)+1);
		        System.out.println(arr[i] + ", frequencies:"+ freq(arrFreq));
		        
		    }
		}

}

		public static String freq(Map<Integer,Integer> map){
		String result = "";
		for(Map.Entry<Integer, Integer> entry : map.entrySet())
		{   
		    //print keys and values
		    result += "f(" + entry.getKey() + ") = "+ " : " + entry.getValue() + ",";
		}
		return result.substring(0,result.lastIndexOf(",")-1);
		
		} 
}

