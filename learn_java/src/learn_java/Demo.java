package learn_java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
 public static void main(String args[]){
	 	Scanner reader = new Scanner(System.in);
	  
	 	Map<Integer, Integer> arrFreq = new HashMap<Integer, Integer>();
		
		int n = reader.nextInt();
		int arr[]=new int[n];
		//System.out.println(n);
		
		for(int i=0;i<n;i++){//for reading array
		    int temp=reader.nextInt();
		    arr[i]=temp;
		    
		    if (!arrFreq.containsKey(temp)){
		        arrFreq.put(temp,1);    
		    }
		    else
		        arrFreq.put(temp,arrFreq.get(temp)+1);    
		    
		}
		
		 
		for(int i=1;i<n;i++){
		    int temp = 0;
		 
		    while(temp<n-i){
		        int result=0;
		            for (int j=0; j<=i; j++){
		              result = result ^ arr[temp+j];  
		              
		            } 
		            System.out.println(result);
		            temp=temp+1;
		        
		        // increase freq
		        if (!arrFreq.containsKey(result)){
		        arrFreq.put(result,1);    
		        }
		        else
		        arrFreq.put(result,arrFreq.get(result)+1);
		    }
		}
		
		int key = 0;
		int freq = 0;
		int count = 0;
		for(Map.Entry<Integer, Integer> entry : arrFreq.entrySet())
		{   
		    //print keys and values
		    if(count ==  0) {
		    	key = entry.getKey(); freq= entry.getValue();
		    	count++;
		    }
		    else{
		    	int temp= entry.getKey();
		    	int temp1 = entry.getValue();
		    	if(temp1 > freq){
		    		key = temp; freq = temp1;
		    	}
		    }
		    	
		}
		
		System.out.println(key +" "+ freq);
		
 }
 
 public static String freq(Map<Integer,Integer> map){
		String result = "";
		for(Map.Entry<Integer, Integer> entry : map.entrySet())
		{   
		    //print keys and values
		    result += "f(" + entry.getKey() + ") = "+ entry.getValue() + ",";
		}
		return result.substring(0,result.lastIndexOf(","));
		
		} 
}
