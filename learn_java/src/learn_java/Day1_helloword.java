package learn_java;

import java.util.Scanner;

public class Day1_helloword {
 public static void main(String[] args) {
	Scanner reader = new Scanner(System.in);
	int number = reader.nextInt();
	for(int i=0; i<number; i++){
		System.out.println("Hello world");
	}
}
}
