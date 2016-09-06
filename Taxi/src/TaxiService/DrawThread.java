package TaxiService;

import restApi.*;

public class DrawThread extends Thread{
	
	public void run(){
		(new Thread(new DrawCar())).start();
	}
}
