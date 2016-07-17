package learn_java;

public class Day1_pattern {
	public static void main(String[] args) {
		String pattern = "0123456789"; 
		/*
		 * Below for loop is for first one
		 */
		
		for(int i=0; i<10; i++){
			String reverse = new StringBuffer(pattern.substring(0, i)).reverse().toString();
			//System.out.println(reverse);
			System.out.println(pattern.substring(0,i+1) + reverse);
		}
		
		/*
		 * Below code is for second one
		 
		for(int i=0; i<10; i++){
			for(int i1=10; i1>=i;i1--) System.out.print(" ");
			String reverse = new StringBuffer(pattern.substring(0, i)).reverse().toString();
			System.out.println(pattern.substring(0,i+1) + reverse);
		}
		*/
		
		for(int i=0; i<10; i++){
			System.out.println((int)Math.pow(11, i));
		}
	}
}
