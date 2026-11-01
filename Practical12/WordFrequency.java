
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        String paragraph = "java is easy java is useful java is popular";

        // Convert paragraph into lowercase words
        String[] words = paragraph.toLowerCase().split(" ");

        HashMap<String, Integer> map = new HashMap<>();

        // Count the frequency of each word
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        // Store all words in a list
        ArrayList<String> list = new ArrayList<>(map.keySet());

        // Sort words by frequency, highest first
        Collections.sort(list, new Comparator<String>() {
            public int compare(String a, String b) {
                return map.get(b) - map.get(a);
            }
        });

        // Display the result
        System.out.println("Word Frequency:");

        for (String word : list) {
            System.out.println(word + " : " + map.get(word));
        }
    }
}
