package JsonParser;

import java.io.File;
import java.io.FileNotFoundException;

public class Token {
	String token;
	int type;
	Token(String token, int type){
		this.token=token;
		this.type=type;
	}
	
	public String toString(){
		
		String s = this.token + "" + this.type;
		return s;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Tokeniser t =  new Tokeniser(new File("/home/amitkumarx86/Downloads/json"));
		t.readFile();
	}

}
