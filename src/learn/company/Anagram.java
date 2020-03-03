package com.company;

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

    private boolean isAnagram(String inputKey1, String inputKey2) {
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
}
