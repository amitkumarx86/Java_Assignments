package Algorithms;

public class GreedyFlorist {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int flowerToPurchase = 3;
        int members = 2;
        int[] fPrice = {2,5,6};
       
    	int j=0;
    	int key,k;
    	int arr_length= flowerToPurchase;
    	for(int i=1;i<flowerToPurchase; i++){
    		j=i-1;
    		key = fPrice[i];
    		while(j >=0 && key < fPrice[j]){
    			fPrice[j+1] = fPrice[j];
    			j=j-1;
    		}

    		fPrice[j+1] = key;
    	} // sort ends
    	
    	int temp = flowerToPurchase;
    	int x =0;
    	int amnt =0, peopleCount=0;
    	int index = flowerToPurchase-1;
    	int[] friends = new int[members];
    	int f_index =0;
    	while(temp != 0){
    		if(members == flowerToPurchase){
    			amnt += fPrice[index--];
    			temp--;
    		}
    		else if(members < flowerToPurchase){
    			
    			if(friends[f_index] == 0){
    				friends[f_index] = 1;
    				amnt += fPrice[index--];
    				fPrice[index+1] = 0;
    				temp--;
    			}
    			else if(friends[f_index] == 1){
    				amnt += (friends[f_index] + 1) * fPrice[0];
    				friends[f_index] = 2;
    				fPrice[0] = 0;
    				temp--;
    				f_index++;
    			}
    			
    		}
    	}
    	System.out.println(amnt);
    	
    }
}
