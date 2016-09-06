package Algorithms;

import java.util.Scanner;

public class SherlockAndArray {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- >0){
            int n = in.nextInt();
            int[] ar = new int[n];
            for(int i = 0 ; i < n ; i++) ar[i] = in.nextInt();
            if(n == 1) {
                System.out.println("YES"); 
                continue;
            }
            int i = 0, j = ar.length -1;
            int sum=0;
            while(i != j && n > 1){
                if(sum >=0) sum -= ar[j--];
                else sum += ar[i++];        
            }
            if(sum==0)System.out.println("YES");
            else System.out.println("NO");
        }
        in.close();
    }
}
