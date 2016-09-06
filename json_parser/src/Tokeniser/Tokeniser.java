package Tokeniser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Tokeniser {
	private String path;
	private static int index=0;
	
	
    
	public Tokeniser(String f){
		this.path = f;
	}
	
	public String readFile() throws UnsupportedEncodingException, IOException{
		String content = new String(Files.readAllBytes(Paths.get(path)));
		//content= content.replaceAll("[ ]*[\r\n\t]+[ ]*", "");
	   return content;
	 }
	public Token getNextToken(String content){
		    if(index >= content.length()){
		    	return null;
		    }
			char token = content.charAt(index);
			//System.out.println(token);
	    	switch(token){
	    	case '{':
	        	Token t1 = new Token(""+token,1);
	        	index++;
	        	return t1;
	        	
	    	case '}':
	        	Token t2 = new Token(""+token,2);
	        	index++;
	        	return t2;
	        	
	    	case '[':
	    		Token t3 = new Token(""+token,3);
	    		index++;
	        	return t3;
	        case ']':
	        	Token t4 = new Token(""+token,4);
	        	index++;
	        	return t4;
	        	
	    	case ',':
	        	Token t5 = new Token(""+token,5);
	        	index++;
	        	return t5;
	        case ':':
	        	Token t6 = new Token(""+token,6);
	        	index++;
	        	return t6;
	        case '"':
	        	Token t7 = new Token(""+token,7);
	        	index++;
	        	return t7;
	        case '\n':
	        	Token t8 = new Token(""+token,8);
	        	index++;
	        	return t8;
	        case '\r':
	        	Token t9 = new Token(""+token,9);
	        	index++;
	        	return t9;
	        case ' ':
	        	Token t11 = new Token(""+token,11);
	        	index++;
	        	return t11;
	        default :
	    		Token t10 = new Token(""+token,10);
	    		index++;
	        	//System.out.println(token + "in while");
	        	return t10;
	        
	    }
		
	}
	
	public void setPath(String path){
		this.path = path;
	}
	public void decreIndex(){
	    this.index--;
	}
	
}
