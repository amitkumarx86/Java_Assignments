package learn_java;

import java.util.Scanner;

public class Prisoner_problem {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
        int T = reader.nextInt();
         
        int key=0;
        int i =0;
        int j=0;
        while(i < T){
        	j=0;
        	int N = reader.nextInt();
            int M = reader.nextInt();
            int S = reader.nextInt();
             
            
            while(M > 0){
                if (S >= N)
                	S = S % N;
                M--;
                S++;
            }
            System.out.println(S-1);
        }
  	}
}
