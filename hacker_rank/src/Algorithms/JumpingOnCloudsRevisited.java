package Algorithms;

import java.util.Scanner;

public class JumpingOnCloudsRevisited {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 19;//in.nextInt();
        int k = 19;//in.nextInt();
        //int c[] = new int[n];
        int c[] = {1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1};
        /*for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }*/
        int i = 0;
        int E = 100;
        i += k;
        if(i >= n) i = i % n;
        E = (c[i] == 0) ? E -1 : E - 2 -1;
        System.out.println("I = "+i + " and E = "+E);
        i += k;
        if(i >= n) i = i % n;
        while(true){
            if(i == 0) {
                E = (c[i] == 0) ? E -1 : E - 2 -1;
                break;
            }
            if(E == 0) break;
            E = (c[i] == 0) ? E -1 : E - 2 -1;
            System.out.println("I = "+i + " and E = "+E); 
            i += k;
            if(i >= n) i = i % n;
        }
        System.out.println(E);
    }
}
