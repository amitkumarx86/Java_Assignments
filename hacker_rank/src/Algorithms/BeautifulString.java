package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BeautifulString {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        read.nextLine();
        String[] s = read.nextLine().split("");
        boolean flag = false;
        for(int i=0; i< s.length-2; i++){
            if(s[i].charAt(0) == '0' && s[i+1].charAt(0) == '1' && s[i+2].charAt(0) == '0'){
                flag = true;
                break;
            }
        }
        if(!flag)
            System.out.println(0);
        else{
            int changeCounter = 0;
            for(int i=0; i< s.length-2; ){
            if(s[i].charAt(0) == '0' && s[i+1].charAt(0) == '1' && s[i+2].charAt(0) == '0'){
                s[i+1] = ""+'1';
                changeCounter++;
                i = i + 3;
            }
            else
                i++;
            
            }
            System.out.println(changeCounter);
            
        }
    }
}
