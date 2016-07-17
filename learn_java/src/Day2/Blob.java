package Day2;
class Blob {
	   int[] space = new int[1000];
	   protected void finalize() throws Throwable {
		     try {
		          System.out.println("Finalize is called");       // close open files
		     } finally {
		         super.finalize();
		     }
		 }
}
