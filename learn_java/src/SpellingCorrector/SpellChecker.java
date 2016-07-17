package SpellingCorrector;

import java.util.stream.Stream;

public interface SpellChecker {
	public Stream<String> distance_1(String word);
	public Stream<String> KnownWordsInDictionary(Stream<String> words);
	public Stream<String> Insert(String word);
	public Stream<String> Delete(String word);
	public Stream<String> Replace(String word);
	public Stream<String> Transform(String word);
}
