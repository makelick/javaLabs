import java.util.HashMap;
import java.util.Map;

class Translator {
    private final Map<String, String> dictionary;

    public Translator() {
        this.dictionary = new HashMap<>();
        addWordPair("hello", "привіт");
        addWordPair("world", "світ");
    }

    public void addWordPair(String englishWord, String ukrainianWord) {
        dictionary.put(englishWord, ukrainianWord);
    }

    public String translatePhrase(String englishPhrase) {
        StringBuilder translatedPhrase = new StringBuilder();
        String[] words = englishPhrase.split(" ");

        for (String word : words) {
            String translation = dictionary.getOrDefault(word, word);
            translatedPhrase.append(translation).append(" ");
        }

        return translatedPhrase.toString().trim();
    }
}