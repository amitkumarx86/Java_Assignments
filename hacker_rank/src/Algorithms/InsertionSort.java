package Algorithms;

public class InsertionSort {
    public static void main(String[] args) {
	int[] a = {5,4,3,2,1};
	for(int i=1;i<a.length;i++){
	    int j=i-1;
	    int key = a[i];
	    while(j>=0 && a[j] > key){
		a[j+1] = a[j];
		j--;
	    }
	    a[j+1] = key;
	}
	for(int i=0;i<a.length;i++)
	    System.out.println(a[i]);
    }
}
