package Algorithms;

import java.util.Scanner;

public class LisaWorkbook {
    public static void main(String[] args) {
	Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int k = read.nextInt();
        int[] arr = new int[n];
        int specialCount = 0;
        int pageCount = 1;
        for(int i=0; i< n;i++){
            arr[i] = read.nextInt();
            for(int j =1,l=1 ; j <= arr[i] ; j++,l++){
	        	if(l > k){
	               pageCount++;
	               l=1;
	            }
	            if(pageCount == j)
	               specialCount++;
	        }
	        pageCount++;
        }
        System.out.println(specialCount);
        read.close();
    }
}
