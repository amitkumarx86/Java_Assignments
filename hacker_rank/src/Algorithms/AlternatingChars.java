package Algorithms;

import java.util.*;
/*
 * Shashank likes strings in which consecutive characters are different. For example, he likes ABABA, while he doesn't like ABAA. Given a string containing characters  and  only, he wants to change it into a string he likes. To do this, he is allowed to delete the characters in the string.

Your task is to find the minimum number of required deletions.

Input Format

The first line contains an integer , i.e. the number of test cases. 
The next  lines contain a string each.

Output Format

For each test case, print the minimum number of deletions required.

Constraints
 * */
public class AlternatingChars {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner read = new Scanner(System.in);
        int t = read.nextInt();
        read.nextLine();
        while(t-- > 0){
           String a = read.nextLine();
           int count = 0,in = 0,jn=1,tempCount=0;
           boolean flag=false;
           for(int i=0;i<a.length()-1;i++){
                   if(a.charAt(in) == a.charAt(jn)){
                        count++;tempCount++;jn++;
                        flag = true;
                   }
                   else{
                       if(flag){
                           in=in+tempCount+1;jn++;
                           tempCount=0;
                           flag=false;
                       }else{
                           in++;jn++;
                       }
                   }
           }
           System.out.println(count); 
        }
        read.close();
    }
}