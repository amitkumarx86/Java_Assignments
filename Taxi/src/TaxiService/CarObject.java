package TaxiService;

public class CarObject {
	private int id;
	private int x;
	private int y;
	private boolean status;
	
	 
	public void setId(int id){
		this.id = id;
	}
	public void setx(int x){
		this.x = x;
	}
	public void sety(int y){
		this.y = y;
	}
	public void setStatus(boolean status){
		this.status = status;
	}
	public int getId(){
		return this.id;
	}
	public int getx(){
		return this.x;
	}
	public int gety(){
		return this.y;
	}
	public boolean getStatus(){
		return this.status;
	}
	
}
