package SpellingCorrector;


import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class SpellingCorrector implements SpellChecker{
    private Map<String,Integer> wordDictionary = new HashMap<>();

    public SpellingCorrector(Path dictionaryFile) throws Exception{
    	
        Stream.of(new String(Files.readAllBytes( dictionaryFile ))
        		.toLowerCase()
        		.replaceAll("[^a-z ]","")
        		.split(" "))
                .forEach( (key) ->
                           {
                        	   wordDictionary.compute( key, (k,v) -> v == null ? 1 : v + 1  );
                           }
                         );
    } // constructor close
    
    public Stream<String> distance_1(String word){
    	
        Stream<String> deletes    = Delete(word);
        Stream<String> replaces   = Insert(word);
        Stream<String> inserts    = Replace(word);
        Stream<String> transposes = Transform(word);
        
        // flat map will combine data coming from different streams into one stream
        Stream<String> retVal = Stream.of( deletes,replaces,inserts,transposes ).flatMap((x)->x);
        
        return retVal;
    }
    
    public Stream<String> KnownWordsInDictionary(Stream<String> words){
        return words.filter( (word) -> wordDictionary.containsKey(word) );
    }
    
    public Stream<String> Insert(String word){
    	return IntStream.range(0, word.length()+1).mapToObj((i)->i)
               .flatMap( (i) -> "abcdefghijklmnopqrstuvwxyz".chars()
               .mapToObj( (c) ->  word.substring(0,i) + (char)c + word.substring(i) )  );
    }
    
	public Stream<String> Delete(String word){
		return  IntStream.range(0, word.length())  
                .mapToObj((i) -> word.substring(0, i) + word.substring(i + 1));
	}
	
	public Stream<String> Replace(String word){
		return IntStream.range(0, word.length())  .mapToObj((i)->i)
	               .flatMap( (i) -> "abcdefghijklmnopqrstuvwxyz".chars()
	               .mapToObj( (c) ->  word.substring(0,i) + (char)c + word.substring(i+1)) );
	}
	
	public Stream<String> Transform(String word){
        // word.substring(i+1,i+2) + word.charAt(i)  code is swapping chars
		return IntStream.range(0, word.length()-1)
                .mapToObj((i)-> word.substring(0,i) + word.substring(i+1,i+2) + word.charAt(i) + word.substring(i+2) );
    }
	
	
    String correct(String word){
    	//optional is a collection like Hashmap
        Optional<String> distance_1_results = KnownWordsInDictionary(distance_1(word))
        		              .max( (firstVal,secondVal) -> wordDictionary.get(firstVal) - wordDictionary.get(secondVal) );
        Optional<String> distance_2_results = KnownWordsInDictionary(distance_1(word)
        		              .map( (w2)->distance_1(w2) ).flatMap((x)->x))
        		              .max( (firstVal,secondVal) -> wordDictionary.get(firstVal) - wordDictionary.get(secondVal) );
        
        return wordDictionary.containsKey(word) ? word : 
        	                   (distance_1_results.isPresent() ? distance_1_results.get() : 
        	                   (distance_2_results.isPresent() ? distance_2_results.get() : word));
    }
}