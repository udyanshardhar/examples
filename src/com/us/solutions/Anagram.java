package com.us.solutions;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(new Anagram().isAnagram("udyan", "uadyn"));
        System.out.println(new Anagram().isAnagram(null, "uadyn"));
        System.out.println(new Anagram().isAnagram(null, null));
        System.out.println(new Anagram().isAnagram("", "uadyn"));
        System.out.println(new Anagram().isAnagram("yan", "uadyn"));
        System.out.println(new Anagram().isAnagram("udyan", "uudyn"));
        System.out.println(new Anagram().isAnagram("uuuu", "uuuuuuuuu"));
        System.out.println(new Anagram().isAnagram("uuuu", "uuuu"));
    }

    public boolean isAnagram(String inputKey1, String inputKey2) {
        if(inputKey1 == null || inputKey2 == null || (inputKey1.length() != inputKey2.length())){
            return false;
        }

        HashMap<Character, Integer> firstInputMap = new HashMap<>();

        for(char temp : inputKey1.toCharArray()){
            if(firstInputMap.containsKey(temp)){
                firstInputMap.put(temp, firstInputMap.get(temp) + 1);
            } else {
                firstInputMap.put(temp, 1);
            }
        }

        for(char temp : inputKey2.toCharArray()){
            if(!firstInputMap.containsKey(temp)){
                return false;
            }

            if(firstInputMap.get(temp) < 1){
            return false;
            }
            firstInputMap.put(temp, firstInputMap.get(temp) - 1);
        }

        return true;
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

}
