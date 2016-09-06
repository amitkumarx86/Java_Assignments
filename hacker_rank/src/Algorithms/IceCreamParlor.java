package Algorithms;

import java.util.Scanner;

public class IceCreamParlor {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        while(T-- >0){
            int cost = in.nextInt();
            int n = in.nextInt();
            int[] ar = new int[n];
            for(int i = 0 ; i < n ; i++) ar[i] = in.nextInt();
            boolean flag = false;
            int i=0,j=ar.length-1;
            int sum=0;
            while(i<j){
                if(ar[i]+ar[j] == cost){
                    System.out.println(++i+" "+(++j));
                    break;
                }
                else if(ar[i]+ar[j] < cost) j--;
                else if(ar[i]+ar[j] > cost) i++;    
            }
        }
        in.close();
    }
}
