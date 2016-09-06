package TaxiService;




/*
 *This is driver class 
 */
public class Taxi123{

   public static void main(String[] a) {
	  DrawThread dt = new DrawThread();   // this thread for drawing the jframe
	  dt.start(); 						  // calling drawing thread
	  System.out.println("Hi I am still running");
   }
}
