package queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QUEUE {
    /*
    public static void main(String[] args) {
	Queue<Integer> q = new LinkedList<Integer>();
    	q.add(1);
    	q.add(2);
    	q.add(3);
    	q.add(4);
    	
    	System.out.println(q.remove());
    	System.out.println(q.remove());
    	System.out.println(q.remove());
    	System.out.println(q.remove());
    	
    	
    }
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         
        int x1 = 42;//in.nextInt();14 4 98 2
        int v1 = 2;//n.nextInt();
        int x2 = 70;//in.nextInt();
        int v2 = 2;//in.nextInt();
        if(x2 >= x1 && v2 >= v1)
            System.out.println("NO");
        else if(x1 >= x2 && v1 > v2)
            System.out.println("NO");
        else if((x1+v1)%(x2+v2) == 0 || (x2+v2)%(x1+v1) == 0)
            System.out.println("YES");
        else{
                int j=x1,k=x2;
                if(x2 >= x1 && v2 <= v1){
                    while(true){
                        if(j == k){
                            System.out.println("YES");
                    	break;
                        } 
                        j += v1;
                        k += v2;  
                        if(k - j < 0){
                            System.out.println("NO");
                    	break;
                        }
                        //System.out.println("j = "+j+" k = "+k);
                     }
                }
                else{
                    while(true){
                        if(j == k){
                            System.out.println("YES");
                    	break;
                        } 
                        j += v1;
                        k += v2;  
                        if(j - k < 0){
                            System.out.println("NO");
                    	break;
                        }
                       // System.out.println("j = "+j+" k = "+k);
                     }
                }

        }    
    }
}
