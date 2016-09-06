package DataStructure;

import java.util.*;

public class DynamicArray {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. 
         * A left rotation operation on an array of size  shifts each of the array's elements 
         * */
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int d = read.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=read.nextInt();
        
        int[] a = new int[n];
        int temp=0;
        for(int i=0;i<n;i++){
            temp = i-d >= 0 ? i-d : n + (i-d);
            a[temp] = arr[i];
        }
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
        
        read.close();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
    }
}
