package Algorithms;


import java.util.Scanner;

public class BiggerIsGreater {
              
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner read = new Scanner(System.in);
        int T = read.nextInt();
        read.nextLine();
        while(T-- >0){
            String s = read.nextLine();
            int len  = s.length();
            int index=0;
            char[] s1 = s.toCharArray();
            char[] sortS = new char[len];
            if(s.length() == 1){
                System.out.println("no answer");
                continue;
            }
            int i=len-1;
            int sIndex=len-1;
            for(;i >= 1;i--){
                if(s1[i] > s1[i-1]){
                    sortS[index++] = s1[i];
                    sIndex--;
                    break;
                }
                else{
                    sortS[index++] = s1[i];
                    sIndex--;
                }
            }
            /*
            for(int j=0;j< index;j++)
                System.out.println("sort[j] = "+sortS[j]+" sIndex = "+sIndex);
            */
            boolean flag = true;
            for(int j=0;j<index;j++){
                if(s1[sIndex] < sortS[j]){
                    char temp = s1[sIndex];
                    s1[sIndex] = sortS[j];
                    sortS[j] = temp;
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                System.out.println("no answer");
                continue;
            }
            for(int j=0;j<index;j++)
                s1[++sIndex] = sortS[j];
            
            if(s.equals(String.valueOf(s1)))
                System.out.println("no answer");    
            else
                System.out.println(String.valueOf(s1));
        }
        read.close();
    }
}
