package Algorithms;

import java.util.Scanner;

public class AngryProfessor {
    public static void main(String[] args) {
	Scanner read = new Scanner(System.in);
        int T = read.nextInt();
        while(T-- > 0){
            int n = read.nextInt();
            int k = read.nextInt();
            int count =0;
            for(int i = 0 ; i < n ; i++){
                if(read.nextInt() <= 0)
                    count++;
            }
            if(count >= k)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
        read.close();
    }
}
