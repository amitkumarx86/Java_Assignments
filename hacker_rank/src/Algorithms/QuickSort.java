package Algorithms;

public class QuickSort {
    static int i = 0;
    static int j = 0;
    public static void main(String[] args)
    {
        QuickSort qsort = new QuickSort();
        int[] array = {5, 4, 7, 2, 1, 9, 3, 6 ,8,10};

        System.out.print("Original  Array : ");
        for(int i=0; i<array.length;i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int length = array.length;
        j=length-1;
        qsort.qSort(array, 0, length-1);
        System.out.println();
        System.out.print("Sorted  Array : ");
        for(int i=0; i<array.length;i++)
        {
            System.out.print(array[i] + " ");
        }
    }
    public void qSort(int[] a, int l, int r)
    {
         if(l<r){
            int p = Pivot(l,r);
            //System.out.println("p="+p);
            a[r] = a[p] + a[r] - (a[p]=a[r]);
            /*System.out.println("Array before partition");
            for(int i=l;i<=r;i++){
        	System.out.print(a[i] + " ");
            }
            */
            //System.out.println();
            int q = Partition(a,l,r);
            /*
            for(int i=l;i<=r;i++){
        	System.out.print(a[i] + " ");
            }
            */
            //System.out.println();
            //System.out.println("q="+q);
            qSort(a, l, q);
            qSort(a, q+1, r);
         }
     }

    private int Pivot(int minimum,int maximum){
	return (minimum + (int)(Math.random()*(maximum - minimum))); 
    }
    private int RandomPartition(int[] A,int l,int r,int p){
	
	while(i <= j){
	    while(A[i] < p) i++;
	    while(A[j] > p) j--;
	    for(int i1=l;i1<=r;i1++){
        	System.out.print(A[i1] + " ");
            }
            System.out.println();
	    if(i<=j) {A[j] = A[i]+A[j] - (A[i]=A[j]);i++;j--;}
	    for(int i1=l;i1<=r;i1++){
        	System.out.print(A[i1] + " ");
            }
            System.out.println();
	}
	//A[j] = A[r]+A[j] - (A[r]=A[j]);
	return j;
    }
     private int Partition(int[] a, int p, int r)
     {
         int x = a[r];
         int i = p-1;
         for(int j=p; j<=r-1; j++)
         {
             if(a[j]<=x) // use if(a[j] >=x) for non-increasing order 
             {
                 i++;a[j]=a[i]+a[j]-(a[i]=a[j]);
             }	
         }
         a[i+1] = a[r] + a[i+1] - (a[r] = a[i+1]);
         return (++i);
     }
     public  int PartitionForPivotAtIndexZero(int[] a, int p, int r)
     {
	 System.out.println("func called...");
         int x = a[0];
         int i = r+1;
         System.out.println(" i ="+(i));
         int temp=0;
         for(int j=r; j > 0; j--)
         {
             if(a[j] >= x) // use if(a[j] >=x) for non-increasing order 
             {
                 i--;
                 temp = a[i];
                 a[i] = a[j];
                 a[j] = temp;
                     
             }
         }
         temp = a[i-1];
         a[i-1] = a[0];
         a[0] = temp;
         for(int a1: a)
             System.out.print(a1+" ");
         System.out.println();
         System.out.println(" i ="+(--i));
         return (i);
     }

}
