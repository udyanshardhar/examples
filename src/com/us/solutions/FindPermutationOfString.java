package com.us.solutions;

public class FindPermutationOfString {
    public static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm + word);


        } else {
            for (int i = 0; i < word.length(); i++) {
                String perm1 = perm + word.charAt(i);
                String word1 = word.substring(0, i) + word.substring(i + 1);
                permutation(perm1, word1);
            }
        }

    }
}
