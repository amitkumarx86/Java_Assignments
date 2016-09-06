package SpellingCorrector;
 
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SpellingTest {

    static  SpellingCorrector spellfixer;

    public static void main(String[] args) throws Exception {
         
        spellfixer	= new SpellingCorrector(Paths.get("/home/amitkumarx86/Downloads/big_doc.txt"));;
        String word="nise";
        
        String correctWord = spellfixer.correct(word);
        if(!word.equals(correctWord))
        System.out.println("Did you mean: "+correctWord);
        else
        	System.out.println(word);
        
        //testing
        //Testing("/home/amitkumarx86/Downloads/Test.txt");
        
        	
 }
public static void Testing(String testFile) throws Exception{
	    Map<String,String> testMap = new HashMap<>();
	    
        
	    BufferedReader br = new BufferedReader(new FileReader(testFile));
	    try {
	        
	        String line = br.readLine();

	        while (line != null) {
	            String[] s= line.split(" ");
	            testMap.put(s[0], s[1]);
	        	line = br.readLine();
	        }
	        
	    } finally {
	        br.close();
	    }
        
	    for(Entry<String, String> m : testMap.entrySet()){
	    	String key = m.getKey();
	    	String value = m.getValue();
	    	System.out.print(key);
	    	String result = spellfixer.correct(key);
	    	String result1 = value.equals(result) ? " "+value : " "+result ;
	    	System.out.println(result1);
	    }
	    
        
    }
}
