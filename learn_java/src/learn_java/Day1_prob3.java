package learn_java;
import java.util.Scanner;

public class Day1_prob3 {
	
	public static void main(String[] args) {
	   
	   Scanner reader = new Scanner(System.in);	
	   int no_cars = reader.nextInt();
	   Car car[] = new Car[no_cars];
	   
	   
	   // input
	   for(int i=0;i<no_cars;i++){
		   int type = reader.nextInt();
		   float car_efficiency = reader.nextFloat();
		   float remaining_fuel = reader.nextFloat();
		   if(type == 1)
		   	car[i] = new DiselCar(car_efficiency, remaining_fuel);
		   else
		   	car[i] = new PetrolCar(car_efficiency, remaining_fuel);
		}
	   
	   
	   // output 
	   for(Car c:car){
			   System.out.println(c.efficiency());
		   }
	   
	   reader.close();
		}
	}

// car class
abstract class Car{
	protected double car_efficiency;
	protected double remaining_fuel;
	abstract protected double efficiency();
}
class DiselCar extends Car {
	public DiselCar(double car_efficiency, double remaining_fuel){
		this.car_efficiency = car_efficiency;
		this.remaining_fuel = remaining_fuel;
	}
	protected double efficiency(){
		return car_efficiency*remaining_fuel;	
	}
}
class PetrolCar extends Car {
	public PetrolCar(double car_efficiency, double remaining_fuel){
		this.car_efficiency = car_efficiency;
		this.remaining_fuel = remaining_fuel;
	}
	protected double efficiency(){
		return 100000/(remaining_fuel/100*car_efficiency);	
	}
}
 
