package Algorithms;

import java.util.Scanner;

public class SaveThePrisoner {
    public static void main(String[] args) {
	Scanner read = new Scanner(System.in);
        int T = 1;//read.nextInt();
        while(T-- > 0){
            int n = 5;//read.nextInt();
            int m = 7;//read.nextInt();
            int i = 5;//read.nextInt();
            while(m!=1){
                    m--;i++;
                    if(i> n) i=i%n;
            }
            System.out.println(i);
        }
        read.close();
    }
}
