import java.util.*;

public class StringChallenges {

    // Reverse a string using normal String concatenation
    public static String reverseWithString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    // Reverse a string using StringBuilder
    public static String reverseWithStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Check if a string is a palindrome using reverseWithString
    public static boolean isPalindromeString(String str) {
        String reversed = reverseWithString(str);
        return str.equals(reversed);
    }

    // Check if a string is a palindrome using StringBuilder
    public static boolean isPalindromeSB(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    // Count vowels and consonants in a string
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) vowels++;
                else consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }

    // Remove duplicate characters from a string
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (result.indexOf(String.valueOf(ch)) == -1) {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Toggle the case of each character in the string
    public static String toggleCase(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) result.append(Character.toLowerCase(ch));
            else if (Character.isLowerCase(ch)) result.append(Character.toUpperCase(ch));
            else result.append(ch);
        }
        return result.toString();
    }

    // Find the first non-repeating character in a string
    public static char firstNonRepeatingChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (str.indexOf(ch) == str.lastIndexOf(ch)) {
                return ch;
            }
        }
        return '_';
    }

    // Remove repeated words from a sentence
    public static String removeRepeatedWords(String str) {
        String[] words = str.split(" ");
        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(words));
        return String.join(" ", set);
    }

    // Sort characters of a string alphabetically
    public static String sortCharacters(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Capitalize the first letter of each word in a sentence
    public static String capitalizeWords(String str) {
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1)).append(" ");
            }
        }
        return result.toString().trim();
    }

    // Print frequency of each character in a string
    public static void charFrequency(String str) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Check if two strings are anagrams
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    // Find the longest word in a sentence
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    // Check if the string is a pangram (contains all letters a-z)
    public static boolean isPangram(String str) {
        str = str.toLowerCase();
        boolean[] alphabet = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                alphabet[ch - 'a'] = true;
            }
        }
        for (boolean present : alphabet) {
            if (!present) return false;
        }
        return true;
    }

    // Remove punctuation characters from a string
    public static String removePunctuation(String str) {
        return str.replaceAll("[\\p{Punct}]", "");
    }

    // Reverse each word in a sentence individually
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuilder(word).reverse().toString()).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        // Testing all methods
        System.out.println(reverseWithString("hello"));
        System.out.println(reverseWithStringBuilder("hello"));
        System.out.println(isPalindromeString("madam"));
        System.out.println(isPalindromeSB("level"));
        countVowelsAndConsonants("Hello World");
        System.out.println(removeDuplicates("aabbccdde"));
        System.out.println(toggleCase("HeLLo WOrLD!"));
        System.out.println(firstNonRepeatingChar("swiss"));
        System.out.println(removeRepeatedWords("this is is a test test string"));
        System.out.println(sortCharacters("zebra"));
        System.out.println(capitalizeWords("hello world"));
        charFrequency("programming");
        System.out.println(areAnagrams("listen", "silent"));
        System.out.println(findLongestWord("this is a simple sentence"));
        System.out.println(isPangram("The quick brown fox jumps over a lazy dog"));
        System.out.println(removePunctuation("Hello, world! This is Java."));
        System.out.println(reverseEachWord("hello world from java"));
    }
}
