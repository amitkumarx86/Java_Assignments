package Day2;

public class GCdemo {
	
		
	public static void main(String[] args) {
	// run this with increasing values of n.
	// How large can n be?
	int n = 1951000;
	Object blobStore[] = new Object[n];
	for(int i=0;i<n;i++) {
	   Blob b = new Blob();
	   //System.gc();
	   blobStore[i] = b;
	   //System.gc();
	}
	}
}