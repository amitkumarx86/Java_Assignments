package Algorithms;

import java.util.Scanner;

public class Sherlock_and_cost {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = 1;//scan.nextInt();
		for(int i=0; i < T; i++){
			
			int N =22;//scan.nextInt();
			//int arr[] = new int[N];
			int arr[] = {75, 26, 45, 72, 81, 47, 29, 97, 2, 75, 25, 82, 84, 17, 56, 32, 2, 28, 37, 57, 39, 18};
			
			for(int j=0 ; j < N; j++){
			   if(j % 2 == 0) arr[j] = arr[j];
			   else {arr[j]=1;//scan.nextInt();
			   }
			   }
			
			// code to compute max possible cost
			System.out.println(cost(arr,N));
		}
	}
	
	public static int cost(int arr[], int N){
		int sum=0;
		for(int j=1 ; j < N; j++){
			sum = sum + Math.abs(arr[j] - arr[j-1]);
		}
		return sum;
	}
}
