package Algorithms;

public class NewYearChaos {
    public static void main(String[] args) {
	//Scanner read = new Scanner(System.in);
        int T = 1;//read.nextInt();
        while(T-- > 0){
            int n = 99927;//read.nextInt();
            int[] arr = {5, 1, 2, 3, 7, 8, 6, 4};//new int[n];
            //for(int i=0 ;i < n ;i++)
              //  arr[i] = read.nextInt();
            int swapCount=0;
            boolean flag = false;
            int compareCount =0;
            int key=0;
            
            for(int i=n-1;i >= 0;i--){
                int temp = i+1;
                int ind=0;
                for(int j= n-1 ; j >= 0 ;j--){
                    if(temp == arr[j]){
               	 ind = j;
               	 if(i - j > 2){
               	     flag = true;
               	 }
               	 else if(i - j == 2)
               	     swapCount += 2;
               	 else if(i - j == 1)
               	     swapCount++;
               	 break;
                    }
                }
                int tempVal = arr[ind];
                int k = ind;
                for( ; k < n-1 ; k++){
                    arr[k] = arr[k+1];
                }
                arr[k] = tempVal;
           }// main for close
           if(flag)
              System.out.println("Too chaotic");
           else
              System.out.println(swapCount);
       }
       //read.close();
    }
}
