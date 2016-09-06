package JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tokeniser {
	File path;
	static int i=0;
	static int tCount=0;
	static ArrayList<Token> objectArr = new ArrayList<Token>();
    
	public Tokeniser(File f){
		this.path = f;
	}
	public void readFile() throws FileNotFoundException{
		String content = new Scanner(path).useDelimiter("\\Z").next();
		System.out.println(content);
	    ArrayList<Token> t = new ArrayList<Token>();
	    //boolean flag=true;
	    int flag=20;
	    while(flag-- >0){
	    	//System.out.println(content.charAt(i));
	    	getNextToken(content);
	    }
		System.out.println(t.toString());
	}
	
	public static void getNextToken(String content){
		//int tCount=0;
		char token;
		//int i=0;
	    
	    token = content.charAt(i);
	    //System.out.println(token);
	    if(token != 'w'){
		    	System.out.println("token "+token);
		    	switch(token){
		        case '{':
		        	System.out.println(token);
		        	Token t = new Token(""+token,1);
		        	objectArr.add(t);
		        	tCount++;
		        	i++;
		        	break;
		        case '}':
		        	System.out.println(token);
		        	Token t1 = new Token(""+token,2);
		        	objectArr.add(t1);
		        	tCount++;
		        	i++;
		        	break;
		        	//return t1;
		        case '[':
		        	System.out.println(token);
		        	Token t2 = new Token(""+token,3);
		        	objectArr.add(t2);
		        	tCount++;
		        	i++;
		        	break;
		        case ']':
		        	System.out.println(token);
		        	Token t3 = new Token(""+token,4);
		        	objectArr.add(t3);
		        	tCount++;
		        	i++;
		        	break;
		        case ',':
		        	System.out.println(token);
		        	Token t4 = new Token(""+token,5);
		        	objectArr.add(t4);
		        	tCount++;
		        	i++;
		        	break;
		        case '\\':
		        	Token t5 = new Token(""+token,6);
		        	objectArr.add(t5);
		        	tCount++;
		        	i++;
		        	break;
		        case ':':
		        	Token t7 = new Token(""+token,7);
		        	objectArr.add(t7);
		        	tCount++;
		        	i++;
		        	break;
		        case '"':
		        	Token t8 = new Token(""+token,8);
		        	System.out.println(token);
		        	objectArr.add(t8);
		        	tCount++;
		        	i++;
		        	break;
		        
		        
		        default :
		        	System.out.println(token + "came in defalt");
		        	String s = ""+token;
		        	
		        	while(content.charAt(i) != '"'){
		        		s += content.charAt(i);
		        		//System.out.println(content.charAt(i));
		        		//System.out.print(" "+s);
		        		i++;
		        	}
		        	Token t9 = new Token(""+token,8);
		        	System.out.println(token + "in while");
		        	objectArr.add(t9);
		        	tCount++;
		        	i++;
		        	
		        	
		        	System.out.println("broke");
		        	System.out.println(s);
		        	Token t6 = new Token(""+s,1);
		        	objectArr.add(t6);
		        	//tCount++;
		        	//i++;
		        	break;
		        
		    } // switch close
		 
	    }// if close
	    else
	    	i++;
	    }
	}
	

