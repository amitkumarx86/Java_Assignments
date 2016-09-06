package Algorithms;

public class StrangeCounter {
    public static void main(String[] args) {
	//Scanner in = new Scanner(System.in);
        long t = 21;//in.nextLong();
        long n = 2;
        while(t > 3 * (n-1)) n *= 2;
        System.out.println(3 * (n-1) - t +1);
    }
}
