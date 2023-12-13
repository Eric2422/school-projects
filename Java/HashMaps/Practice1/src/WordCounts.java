import java.util.*;

public class WordCounts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // get a String of three sentences from the user
        System.out.println("Enter three sentences in a single line: ");
        String sentences = input.nextLine().toLowerCase();

        // split the sentences into words using regular expresssions
        // \\W+ finds all sequences of non-word characters
        // and treats them as separating words
        ArrayList<String> splitSentences = new ArrayList<>(Arrays.asList(sentences.split("\\W+")));

        // create a HashMap to store the word counts
        HashMap<String, Integer> wordCount = new HashMap<>();

        // loop through the set
        for (String ele : splitSentences) {
            wordCount.put(ele, Collections.frequency(splitSentences, ele));
        }

        System.out.println();
        printSortedHashMap(wordCount);
    }

    /*
     * This method takes a HashMap of word counts and prints out
     * each word and it's associated count in alphabetical order.
     *
     * @param wordCount The HashMap mapping words to each word's frequency count
     */
    private static void printSortedHashMap(HashMap<String, Integer> wordCount) {
        // Sort all the keys (words) in the HashMap
        Object[] keys = wordCount.keySet().toArray();
        Arrays.sort(keys);

        // Print out each word and it's associated count
        for (Object word : keys) {
            int val = wordCount.get(word);
            System.out.println(word + ": " + val);
        }
    }
}