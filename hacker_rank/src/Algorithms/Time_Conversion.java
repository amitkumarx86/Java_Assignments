package Algorithms;

import java.util.Scanner;

public class Time_Conversion {
	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
	        String time = in.next();
	        String[] timeSplitted = time.split(":");
	        String hour="";
	        if(time.endsWith("PM") && new Integer(timeSplitted[0]) != 12 ){
	        	Integer hr = new Integer(timeSplitted[0]);
	        	hr = (hr + 12) % 24 ;
	        	if(hr == 0) hour = "00";
		        else hour = hr.toString();
	        }
	        else if(time.endsWith("AM") && new Integer(timeSplitted[0]) > 11 || (new Integer(timeSplitted[1]) >= 0 || new Integer(timeSplitted[2].replaceAll("AM", "")) >= 0)){
	        	Integer hr = new Integer(timeSplitted[0]);
	        	hr = (hr + 12) % 24 ;
	        	if(hr == 0) hour = "00";
		        else hour = hr.toString();
	        }	
	        else
	        	hour = timeSplitted[0];
	        
	        time = hour+":"+timeSplitted[1]+":"+timeSplitted[2];
	        System.out.println(time.replaceAll("PM", "").replaceAll("AM", ""));
	}
}