package Parser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import TaxiService.CarObject;

public class Token {
	private String token;
	private int type;
	
	private static Map<Object,Object> map = new HashMap<Object,Object>();
	static ArrayList<CarObject> carObj = new ArrayList<CarObject>();
	 
	
	Token(String token, int type){
		this.token=token;
		this.type=type;
	}
	
	// Default Constructor
	public Token(){}
	
	public  ArrayList<CarObject> parser(String Json) throws UnsupportedEncodingException, IOException{
		Tokeniser tokeniser =  new Tokeniser();
		//String content = tokeniser.readFile();
		
		String content = tokeniser.cleanJson(Json);
		int nextToken=0;
		int counter=0;
		String value,key = null;
		
		while(true){
			Token t = new Token();
			t = tokeniser.getNextToken(content);
			if(t == null){
				//System.out.println("JSON is parsed");
				break;
			}
			if(nextToken == 8){
				//System.out.println(t.token+ " " + t.type);
				if(t.type != 8 && !t.token.equals("]")){
					//System.out.println("\" expected after key");
					throw new IllegalArgumentException("\" expected after key");
				}
				nextToken =0;
			}
			//for "
			if(t.type == 9 || t.type == 10){
				nextToken = 8;
				if(counter == 0){
					key = t.token;
					counter++;
				}
				else{
					value = t.token;
					value = value.replace("[", "");
					
					if(key.equals("status")){
						map.put(key, value);
						CarObject car = new CarObject();
						for(Map.Entry<Object, Object> m : map.entrySet()){
							if(m.getKey().equals("id")){
								car.setId(Integer.parseInt((String)m.getValue()));
							}
							else if(m.getKey().equals("x")){
								car.setx(Integer.parseInt((String)m.getValue()));
							}
							else if(m.getKey().equals("y")){
								car.sety(Integer.parseInt((String)m.getValue()));
							}
							else{
								car.setStatus(Integer.parseInt((String)m.getValue()) == 1 ? true : false);
							}
						}// Object created 
						// Add object into arraylist of CarObject
						carObj.add(car);
					}
					else{
						map.put(key, value);
						//System.out.println("Gt key = " + key + " value " + value);
					}
					 
					//jsonObject.add(new JsonObject(key, value));
					counter =0;
				}
				
			}
			//System.out.println("Token = "+ t.token + "  type = "+t.type);
		
		}// while close
		return carObj;
	}// func close

public static void main(String[] args) throws UnsupportedEncodingException, IOException {
	Token t = new Token();
	t.parser("/home/amitkumarx86/Downloads/json");
	/*
	for (JsonObject json : jsonObject){
        System.out.print(json.getKey() + "->");
        System.out.println(json.getValue());
    }
    */
}// main close

}// class close