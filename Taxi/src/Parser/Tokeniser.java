package Parser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Tokeniser {
	private String path;
	private static int index=0;
	
	
    
	public Tokeniser(String f){
		this.path = f;
	}
	
	public Tokeniser(){}
	
	public String readFile() throws UnsupportedEncodingException, IOException{
		String content = new String(Files.readAllBytes(Paths.get(path)));
		content= content.replaceAll("[ ]*[\r\n\t]+[ ]*", "");
	   return content;
	 }
	
	public String cleanJson(String Json){
		return Json.replaceAll("[ ]*[\r\n\t]+[ ]*", "");
	}
	public Token  getNextToken(String content){
		    if(index >= content.length()){
		    	return null;
		    }
			char token = content.charAt(index);
			//System.out.println(token);
	    	switch(token){
	    	case '{':
	        	Token t = new Token(""+token,1);
	        	index++;
	        	return t;
	        	
	    	case '}':
	        	Token t1 = new Token(""+token,2);
	        	index++;
	        	return t1;
	        	
	    	case '[':
	    		String s = "";
	        	while(content.charAt(index) != ']'){
	        		s += content.charAt(index++);
	        		//System.out.println(s);
	        	}
	        	//System.out.println(s);
	        	Token t10 = new Token(""+s,10);
	        	//System.out.println(token + "in while");
	        	return t10;
	        case ']':
	        	Token t3 = new Token(""+token,4);
	        	index++;
	        	return t3;
	        	
	    	case ',':
	        	Token t4 = new Token(""+token,5);
	        	index++;
	        	return t4;
	        	
	    	case '\\':
	        	Token t5 = new Token(""+token,6);
	        	index++;
	        	return t5;
	        	
	    	case ':':
	        	Token t7 = new Token(""+token,7);
	        	index++;
	        	return t7;
	        	
	    	case '"':
	        	Token t8 = new Token(""+token,8);
	        	index++;
	        	return t8;
	        	
	    	default :
	    		
	    		String s1 = "";
	        	while(content.charAt(index) != '"'){
	        		char temp9 = content.charAt(index++);
	        		
	        		if(temp9 != '}' ){
	        			if(temp9 != ',')
	        			s1 += temp9;
	        		}
	        		if(index >= content.length())
	        			break;
	        		
	        	}
	        	//System.out.println("Key = "+s1);
	        	//System.out.println(s);
	        	s1=s1.replace("{", "");
	        	Token t9 = new Token(""+s1,9);
	        	//System.out.println(token + "in while");
	        	return t9;
	        
	    }
		
	}
	
	public void setPath(String path){
		this.path = path;
	}
	
}
