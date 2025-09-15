import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class prac {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String sentence = scn.nextLine().toLowerCase();
        String word = scn.nextLine().toLowerCase();
        System.out.println(CountWord(sentence, word));
    }

    public static int countWord(String sentence, String word){

        Map<Character, Integer> wordCounter = new HashMap<>();

        for(char c : word.toCharArray()) {
            wordCounter.put(c, wordCounter.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sentenceCounter = new HashMap<>();

        for(char c : sentence.toCharArray()) {
            sentenceCounter.put(c, sentenceCounter.getOrDefault(c, 0) + 1);
        }

        int res = Integer.MAX_VALUE;
        for(Map.Entry<Character, Integer> entry : wordCounter.entrySet()) {
            char ch = entry.getKey();
            int needed = entry.getValue();
            int available = sentenceCounter.getOrDefault(ch, 0);

            int possible = available / needed;

            res = Math.min(res, possible);
        }
        return res;
    }

    // optimized solution : Since we only deal with lowercase English letters ('a'–'z'), we can map each character to an index (c - 'a').

    public static int CountWord(String sentence, String word) {
        int[] sentenceFreq = new int[26];
        int[] wordFreq = new int[26];

        for(char c : sentence.toCharArray()) {
            sentenceFreq[c - 'a']++;
        }
        for(char c : word.toCharArray()) {
            wordFreq[c - 'a']++;
        }

        int output = Integer.MAX_VALUE;

        for(int i = 0; i < 26; i++) {
            if(wordFreq[i] > 0) {
                int possible = sentenceFreq[i] / wordFreq[i];
                output = Math.min(output, possible);
            }
        }
        return output;
    }
}

/*
    Explanation: In the sentence "hellohellohello", the word "hello" can be constructed 3 times because there are enough 
    occurrences of each character in "hello" to form the word three times.
    Constraints: The sentence and word will contain only lowercase English letters
 */