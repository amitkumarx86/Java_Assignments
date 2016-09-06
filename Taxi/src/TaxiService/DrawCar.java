package TaxiService;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

 
import restApi.*;
import Parser.*;

public class DrawCar extends JPanel implements Runnable , MouseListener{
	 /**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 
	 private static int car_width = 20;
	 private static int car_hight = 40;
	 private String image_path_booked = "/home/amitkumarx86/Pictures/icons/red_car.png";
	 private String image_path_available = "/home/amitkumarx86/Pictures/icons/green_car.png";
	 private String url="http://demo2701524.mockable.io/taxi";
	 private static ArrayList<Taxi> carDetails ;
	 private TaxiFleet fleet;
	 private int click_x;
	 private int click_y;
	 private int click_count=0;
	  
	 
	 public DrawCar(){
		 fleet = new TaxiFleet();
		 fleet.start(25);
		 addMouseListener(this);
	}
	 
	 public void DrawTaxi(){
		 
		 carDetails = fleet.getTaxis();
		 int N = 25;
		 /*
		 while(N-- >0){
			 System.out.println(carDetails.get(N).toString());
		 }
		 */
		 this.repaint();
		 
		   /*
		   // getting Json
		   GetApi getApi = new GetApi(url);
		   String data   = getApi.getCarDetails();
		   System.out.println(data);
		   // Parsing Json
		   
		   Token token = new Token();
		   try {
			   carDetails = token.parser(data);  // passing json to parser
			   
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   */
	 }
     public void paintComponent(Graphics g) {
    	   
	       super.paintComponent(g);
	       // Call rest API to get the data
    	   //System.out.println("Going to draw..");
    	   
    	   //int t = carDetails.size();
    	   if(carDetails != null){
    		 
    	     for(Taxi taxis : carDetails){
	    		   try {
						draw(g,taxis.getTaxiId(),
						   taxis.getLocation().getX(),
						   taxis.getLocation().getY(),
						   taxis.isBusy());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		   
	    	   }
    	   }
	       
	   }
     
	   public void draw(Graphics g,int id,int x,int y, boolean status) throws IOException {
		   BufferedImage image = ImageIO.read(status ?   new File(image_path_booked) : new File(image_path_available));
	       g.drawString(new String(id+""), x, y);
	       g.drawImage(image, x, y,car_width,car_hight, null);
	   }
	@Override
	public void run() {
		  while(true){
			  DrawTaxi(); // calling function to draw cars 
			  //System.out.println("Dra called ..");
			  //createUI(); // calling function to draw UI
			  try {
				Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }
	}
	public static void createUI(DrawCar d){
		  JFrame homePanel = new JFrame();
		  homePanel.setSize(1000,1000);
		  homePanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  homePanel.setTitle("Taxi Service");
		  // Adding menu
		  JMenuBar menuBar = new JMenuBar();
		  JMenu menu = new JMenu("Home");
		  menuBar.add(menu);
		  JMenuItem menuItem = new JMenuItem("Book Ride");
		  menu.add(menuItem);
		  homePanel.setJMenuBar(menuBar);
		  
		  
		  //Adding label
		  JLabel label = new JLabel("Taxi App");
		  label.setVerticalAlignment(JLabel.TOP);
		  label.setVerticalTextPosition(JLabel.TOP);
		  label.setHorizontalAlignment(SwingConstants.CENTER);
		  label.setHorizontalAlignment(SwingConstants.CENTER);
		  homePanel.getContentPane().add(label);
		  
		  homePanel.setVisible(true);
		  homePanel.add(d); // calling function 
		  //homePanel.setVisible(true);
		  
	}
	public static void main(String[] args) {
		 //createUI(); // calling create UI to draw jframe
          DrawCar d = new DrawCar();
		  createUI(d);
		  (new Thread(d)).start();
		 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(click_count == 0){
			click_x = e.getX();
			click_y = e.getY();
			click_count = 1;
			System.out.println("Mouse clicked at " + click_x + " " + click_y);
			int taxi_id = fleet.request(100, new Location(click_x, click_y));
			System.out.println(taxi_id + " got allocated..");
			this.repaint();
		}
		else{
			click_x = e.getX();
			click_y = e.getY();
			click_count = 0;
			int balance = fleet.release(100, new Location(click_x, click_y));
			System.out.println("balance = "+ balance);
			this.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
