package Day2;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {
public static void main(String[] args) {
	Scanner reader = new Scanner(System.in);
	String a = reader.nextLine().toLowerCase();
	String b = reader.nextLine().toLowerCase();
	Boolean flag=true;
	int[] arr = new int[26];
	if(a.length() == a.length())
	{
		a.toLowerCase();
        b.toLowerCase();
        for(int i=0; i<26; i++)
        	arr[i] = 0;
		for(int i=0;i < a.length() ; i++){
			int temp = (int)a.charAt(i) - 97;
			arr[temp] = arr[temp]  + 1;
			
		}
		for(int i=0;i < a.length() ; i++){
			int temp = (int)b.charAt(i) - 97;
			arr[temp] = arr[temp]  - 1;
			
		}
		for(int i=0; i<26; i++)
        	if(!(arr[i] == 0)){
        		flag=false;
        		break;
        	}
        		
	}
	else
		flag=false;
	System.out.println(flag);
}
}
