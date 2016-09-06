package Algorithms;

import java.util.Scanner;

public class NonDivisibleSubset {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner read = new Scanner(System.in);
        int N = 10;////read.nextInt();
        int K = 4;//read.nextInt();
        long arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //long[] arr = {10, 4,1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //long[] arr = {3, 7, 5, 7, 3, 2};
        //long[] arr = {422346306, 940894801, 696810740, 862741861, 85835055, 313720373};//{1,2,4,7}; //new long[N];
        
        long[] bucket = new long[K];
        for(int i=0;i< K;i++)
            bucket[i]=0;
        for(int i=0; i< N ;i++){
            //arr[i] = read.nextLong();
            System.out.println("arr[i] = "+ arr[i] + "\t" + (int )arr[i]%K);
            bucket[(int)arr[i]%K] = bucket[(int)arr[i]%K] + 1;
        }
        for(int i=0;i<K;i++) System.out.println("bucket[i]"+bucket[i]); 
        
        int count = 0;
        for(int i=1;i<= K/2;i++){
            System.out.println("bucket[i]"+bucket[i] + "buck[k-i]"+bucket[K-i]);
            if(i == K-i && bucket[K-i] > 0)
        	count += 1;
            else
        	count += bucket[i] > bucket[K-i] ? bucket[i] : bucket[K-i];
            System.out.println(count);
        }
        if(bucket[0] > 1){
            count += 1;
        }
        //if(K%2 == 0)
           // count += 1;
        
        System.out.println("final = "+count);
        
        
        
        
        read.close();
    }
}
