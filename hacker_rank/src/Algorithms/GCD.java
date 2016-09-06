package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCD {
public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        while(T-- >0){
        	int n = Integer.parseInt(br.readLine());
        	int m = Integer.parseInt(br.readLine());
        	int p1 = 9 * m;
        	int p2 = 8 *n + m;
        	int gcd = GCD(p1,p2);
        	System.out.println((p1/gcd)+"/"+(p2/gcd));
        }
       
    }
    public static int GCD(int number1, int number2){
	if(number2 == 0)return number1;  
	return GCD(number2, number1%number2);
    }
}
