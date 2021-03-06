package Algorithms;

import java.util.Scanner;

public class InsertionSortCalculateShifts {
    public static void insertionSort(int[] A){
            int noShift=0;
            for(int i = 1; i < A.length; i++){
                int value = A[i];
                int j = i - 1;
                while(j >= 0 && A[j] > value){
                    noShift++;
                    A[j + 1] = A[j];
                    j = j - 1;
                }
                A[j + 1] = value;
            }
            System.out.println(noShift);
        }
        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] ar = new int[n];
            for(int i=0;i<n;i++){
                ar[i]=in.nextInt();
            }
            insertionSort(ar);
            in.close();
        }
    
}
