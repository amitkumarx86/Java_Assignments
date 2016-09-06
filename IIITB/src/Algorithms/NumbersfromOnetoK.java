package Algorithms;

public class NumbersfromOnetoK {
    public static void main(String[] args) {
	NumbersfromOnetoK m = new NumbersfromOnetoK();
	m.findSubArrayWith_1_to_K_Numbers();
    }
    private void findSubArrayWith_1_to_K_Numbers(){
	int[] arr={10,6,3,7,6,4,2,8,6,1,2,7,7,1,2,3,4,7,3,4,7,7,7,1,2,9,9,9,9,9,9};
	//System.out.println(arr.length);
	int k=4,strtInd=0,endInd=0,digCount=0;
	int[] kArr=new int[k+1];

	/*
	 * First find the sub array in which 1 to k number exist, it may 
	 * not be the minimal then we will try to minimize it
	 * */
	for(int i=0;i<arr.length;i++){  
	    if(arr[i] <=k && arr[i] >=1){
		if(kArr[arr[i]]==0) digCount++;
		kArr[arr[i]]++;
		if(digCount == k) {endInd=i;break;}
	    }
	}
	
	int min_len=endInd-strtInd+1,tempInd=endInd;
	int i=strtInd;
	//System.out.println(" min_len="+min_len);
	while(tempInd<arr.length){
	    if(arr[i]<=k){
		//System.out.println("i="+i+" arr[i]:"+arr[i]+" tempInd="+tempInd+" arr[tempInd]:"+arr[tempInd]);
		kArr[arr[i]]--;
		//printArray(kArr);
		if(kArr[arr[i]] == 0){
		    kArr[arr[i]]++;
		    if(tempInd-i+1 < min_len){
			min_len=tempInd-i+1;
			strtInd=i;endInd=tempInd;
			//System.out.println(" min_len="+min_len);
		    }
		    //printArray(kArr);
		    if(tempInd < arr.length)
			tempInd++;
		    while(tempInd < arr.length && arr[tempInd] > k)tempInd++;
		    if(tempInd < arr.length)
			kArr[arr[tempInd]]++;
		    //printArray(kArr);
		    //System.out.println(tempInd);
		    //System.out.println(min_len+" "+(tempInd-i+1));
		}
		else
		    	i++;
	    }
	    else
		i++;
	    
	}
	System.out.println(strtInd+" "+(endInd));
    }
    private void printArray(int[] arr){
	for(int a : arr) System.out.print(a+" ");
	System.out.println();
    }
}
