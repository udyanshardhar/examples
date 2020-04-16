package com.us.solutions;

import java.util.*;
import java.util.regex.Pattern;

public class StringProblems {
    public static void main(String[] args) {
        printDuplicateCharacters("Programming");
        printDuplicateCharacters("Combination");
        printDuplicateCharacters("Java");
        permutation("abc");
        findAllSubString("abc");
    }



    /* * Find all duplicate characters in a String and print each of them. */
    public static void printDuplicateCharacters(String word) {
        char[] characters = word.toCharArray();
        // build HashMap with character and number of times they appear in String
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (Character ch : characters) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        // Iterate through HashMap to print all duplicate characters of String
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", word);
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }

    }

    // How to check if two Strings are anagrams of each other
    /*
     * One way to find if two Strings are anagram in Java. This method
     * assumes both arguments are not null and in lowercase.
     *
     * @return true, if both String are anagram
     */
    public static boolean isAnagram1(String word, String anagram){
        if(word.length() != anagram.length()){
            return false;
        }

        char[] chars = word.toCharArray();

        for(char c : chars){
            int index = anagram.indexOf(c);
            if(index != -1){
                anagram = anagram.substring(0,index) + anagram.substring(index +1, anagram.length());
            }else{
                return false;
            }
        }
        return anagram.isEmpty();
    }
    public static boolean iAnagram2(String word, String anagram){
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);

        return Arrays.equals(charFromWord, charFromAnagram);
    }
    public static boolean checkAnagram3(String first, String second){
        char[] characters = first.toCharArray();
        StringBuilder sbSecond = new StringBuilder(second);

        for(char ch : characters){
            int index = sbSecond.indexOf("" + ch);
            if(index != -1){
                sbSecond.deleteCharAt(index);
            }else{
                return false;
            }
        }
        return sbSecond.length()==0 ? true : false;
    }



    /*
     * Using LinkedHashMap to find first non repeated character of String
     * Algorithm :
     *            Step 1: get character array and loop through it to build a
     *                    hash table with char and their count.
     *            Step 2: loop through LinkedHashMap to find an entry with
     *                    value 1, that's your first non-repeated character,
     *                    as LinkedHashMap maintains insertion order.
     */
    public static char getFirstNonRepeatedChar(String str) {
        Map<Character,Integer> counts = new LinkedHashMap<>(str.length());

        for (char c : str.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }

        for (Map.Entry<Character,Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }


    /*
     * Finds first non repeated character in a String in just one pass.
     * It uses two storage to cut down one iteration, standard space vs time
     * trade-off.Since we store repeated and non-repeated character separately,
     * at the end of iteration, first element from List is our first non
     * repeated character from String.
     */
    public static char firstNonRepeatingChar(String word) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(0);
    }


    /*
     * Using HashMap to find first non-repeated character from String in Java.
     * Algorithm :
     * Step 1 : Scan String and store count of each character in HashMap
     * Step 2 : traverse String and get count for each character from Map.
     *          Since we are going through String from first to last character,
     *          when count for any character is 1, we break, it's the first
     *          non repeated character. Here order is achieved by going
     *          through String again.
     */
    public static char firstNonRepeatedCharacter(String word) {
        HashMap<Character,Integer> scoreboard = new HashMap<>();
        // build table [char -> count]
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (scoreboard.containsKey(c)) {
                scoreboard.put(c, scoreboard.get(c) + 1);
            } else {
                scoreboard.put(c, 1);
            }
        }
        // since HashMap doesn't maintain order, going through string again
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (scoreboard.get(c) == 1) {
                return c;
            }
        }
        throw new RuntimeException("Undefined behaviour");
    }

    public static String reverse2(String str) {
        StringBuilder strBuilder = new StringBuilder();
        char[] strChars = str.toCharArray();

        for (int i = strChars.length - 1; i >= 0; i--) {
            strBuilder.append(strChars[i]);
        }

        return strBuilder.toString();
    }

    public static String reverse2Recursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverse2Recursively(str.substring(1)) + str.charAt(0);

    }

    public static String reverseString3(String str) {
        return new StringBuffer(str).reverse().toString();
    }


    // Regular expression in Java to check if String is number or not
    // Check if a String is a number
    public static void checkStringMadeOfNumber() {
        Pattern pattern = Pattern.compile(".*\\D.*");
        // Pattern pattern = Pattern.compile(".*\\d.*");
        // Pattern digitPattern = Pattern.compile("\\d{6}");
        // Pattern pattern = Pattern.compile(".*[^0-9].*");
        Pattern digitPattern = Pattern.compile("\\d{6}");
        //Pattern digitPattern = Pattern.compile("\\d\\d\\d\\d\\d\\d");
        String [] inputs = {"123", "-123" , "123.12", "abcd123"};

        for(String input: inputs){
            System.out.println( "does " + input + " is number : "
                    + !pattern.matcher(input).matches());
        }
    }


    public static int vovelCount(String input) {

        char[] letters = input.toCharArray();
        int count = 0;
        for (char c : letters) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
                default:
            }
        }

        return count;
    }

    // count the number of occurrence of any character on String.
    public static void countVovels() {
        String input = "Today is Monday"; //count number of "a" on this String.

        // Using Spring framework StringUtils class for finding occurrence of another String
        // int charCount = StringUtils.countOccurrencesOf(input, "a");
        // Using Apache commons lang StringUtils class
        int charCount = 0;
        // charCount = org.apache.commons.lang.StringUtils.countMatches(input, "a");
        // System.out.println("count of character 'a' on String: 'Today is Monday' using commons StringUtils " + number)
        //counting occurrence of character with loop
        charCount = 0;
        for(int i =0 ; i<input.length(); i++){
            if(input.charAt(i) == 'a'){
                charCount++;
            }
        }
    }


    // Convert String and int

    public static void IntStringIntConversion() {
        System.out.println(Integer.valueOf("12"));
        System.out.println(Integer.parseInt("14"));
        System.out.println(""+12);
        System.out.println(String.valueOf(12));
    }

    // How to replace each given character to other e.g. blank with %20? (solution)


    /*
     * A method exposed to client to calculate permutation of String in Java.
     */
    public static void permutation(String input){
        permutation("", input);
    }

    /*
     * Recursive method which actually prints all permutations
     * of given String, but since we are passing an empty String
     * as current permutation to start with,
     * I have made this method private and didn't exposed it to client.
     */
    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm + word);


        } else {
            for (int i = 0; i < word.length(); i++) {
                String perm1 = perm + word.charAt(i);
                String word1 = word.substring(0, i) + word.substring(i + 1, word.length());
                permutation(perm1, word1);
            }
        }

    }


    /** * Java Program to reverse words in String. There are multiple way to solve this * problem.
     * you can either use any collection class e.g. List and reverse the *
     * List and later create reverse String by joining individual words.
     */


    public static String reverseWords(String sentence) {
        List< String> words = Arrays.asList(sentence.split("\\s"));
        Collections.reverse(words);
        StringBuilder sb = new StringBuilder(sentence.length());
        for (int i = words.size() - 1; i >= 0; i--) {
            sb.append(words.get(i)); sb.append(' ');
        }
        return sb.toString().trim();
    }
    public static String reverseString(String line) {
        if (line.trim().isEmpty()) {
            return line;
        }
        StringBuilder reverse = new StringBuilder();
        String[] sa = line.trim().split("\\s");
        for (int i = sa.length - 1; i >= 0; i--) {
            reverse.append(sa[i]); reverse.append(' ');
        }
        return reverse.toString().trim();
    }

    /** * Java method to check if given String is Palindrome * @param text * @return true if text is palindrome, otherwise false */
    public static boolean isPalindromString(String text){
        String reverse = reverse(text);
        if(text.equals(reverse)){
            return true;
        }
        return false;
    }
    /** * Java method to reverse String using recursion * @param input * @return reversed String of input */
    public static String reverse(String input){
        if(input == null || input.isEmpty()){
            return input;
        }
        return input.charAt(input.length()- 1) + reverse(input.substring(0, input.length() - 1));
    }


    // How to remove duplicate characters from String? (solution)

    // How to check if a String is valid shuffle of two String? (solution)


    //Write a program to check if a String contains another String e.g. indexOf()? (solution)


    //How  to return highest occurred character in a String? (solution)


    //Write a program to remove a given characters from String

    public static String remove(String word, char unwanted){
        StringBuilder sb = new StringBuilder();
        char[] letters = word.toCharArray();

        for(char c : letters){
            if(c != unwanted ){
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String removeRecursive(String word, char ch){
        int index = word.indexOf(ch);
        if(index == -1){
            return word;
        }
        return removeRecursive(word.substring(0, index) + word.substring(index +1, word.length()), ch);
    }


    // Write a program to find longest palindrome in a string? (solutio

    // How to sort String on their length in Java

    // Find all subString of a string

    public static List<String> findAllSubString(String input) {
        List<String> res = new ArrayList<>();
        for(int i =0; i < input.length(); i++) {
            for(int j = i+1; j <= input.length(); j ++){

                System.out.println(input.substring(i , j));
                res.add(input.substring(i , j));
            }
        }
        return res;
    }


}
