package Tokeniser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Parser.JsonObject;

public class Token {
	String token;
	int type;
	static ArrayList<Object> jsonObject = new ArrayList<Object>();
	static Map<Object,Object> map = new HashMap<Object,Object>();
	
	static Tokeniser tokeniser;
	Token(String token, int type){
		this.token=token;
		this.type=type;
	}
	public Token(){}
	public String toString(){
		
		String s = this.token + "" + this.type;
		return s;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException, IOException, Exception {
		String path = "/home/amitkumarx86/Downloads/json";
		tokeniser =  new Tokeniser(path);
		String content = tokeniser.readFile();
		System.out.println(parser(content).toString());
	}
	
	public static Object parser(String content) throws UnsupportedEncodingException, IOException, Exception{
		Object value=null,key = null;
		Map<Object,Object> mp;
		while(true){
		        Token t = new Token();
		        t = tokeniser.getNextToken(content);
		        mp = new HashMap<Object,Object>();
		    	if(t != null){
        		    	if(t.type == 11) continue;
        		    	if(t.type == 2) break; // terminate because of }
        		    	if(t.type == 1){
        		    	    key = getKey(content);
                		    System.out.println("key = "+key);
                		}
        		    	if(t.type == 6){
            			     //System.out.println("val is called...");
                		     value = getValue(content);
                		     System.out.println("key = " + key + " value = " + value);
                		     
                		}
            			
            			//System.out.println("key = " + key + " value = " + value);
            			mp.put(key, value); // adding values to hashmap
        		}
		    	else
        		    break; // string finished
		}
		return mp;
		
	}
	public static String getKey(String content) throws Exception{
	    String key = "";
	    Token t = new Token() ;
	    t = tokeniser.getNextToken(content);
	   
	    while(t.type == 11 || t.type == 8 || t.type == 9){
		t = tokeniser.getNextToken(content);
	    }
	     
	    if(t.type == 7){  // 3 is for "
		t = tokeniser.getNextToken(content);
		while(t.type != 7){
		    if(t.type == 11 || t.type == 9 || t.type == 8) {
			t = tokeniser.getNextToken(content);
			continue;
		    }
		    key += t.token;
		    t = tokeniser.getNextToken(content);
		    if(t.type == 6){
			throw new Exception("\" is expected");
		    }
		    //System.out.println(t.token);
		}
		if(tokeniser.getNextToken(content).type != 5) tokeniser.decreIndex();
	    }
	    
	    return  key;
	    
	}
	public static Object getValue(String content) throws Exception{
	    Token t = new Token();
	    Object value = "";
	    t = tokeniser.getNextToken(content);
	    while(t.type == 11) t = tokeniser.getNextToken(content);
	    if(t.type == 1){
		while(t.type == 11) t = tokeniser.getNextToken(content);
		tokeniser.decreIndex();
		value = parser(content);
		if(tokeniser.getNextToken(content).type != 5) tokeniser.decreIndex();
	    }
	    if(t.type == 7){
		t = tokeniser.getNextToken(content);
		while(t.type != 7){
		    if(t.type == 9) {
			t = tokeniser.getNextToken(content);
			continue;
		    }
		    value += t.token;
		    t = tokeniser.getNextToken(content);
		}
		if(tokeniser.getNextToken(content).type != 5) tokeniser.decreIndex();
	    }
	    if(t.type == 3){
		ArrayList<Object> obj = new ArrayList<Object>();
		String valTemp = "";	
		t = tokeniser.getNextToken(content);
		while(t.type != 4){
		    if(t.type == 9 || t.type == 7) {
			t = tokeniser.getNextToken(content);
			continue;
		    }
		    if(t.type == 5){
			obj.add(valTemp);
			t = tokeniser.getNextToken(content);
			valTemp = "";
			continue;
		    }
		    if(t.type != 11)
		    valTemp += t.token;
		    t = tokeniser.getNextToken(content);
		}
		obj.add(valTemp);
		value = obj;
		if(tokeniser.getNextToken(content).type != 5) tokeniser.decreIndex();
	    }
	    return value;
	}
}
