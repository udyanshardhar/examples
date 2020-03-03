package learn;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("flower");
        input.add("flow");
        input.add("flower");
        System.out.println(LongestCommonPrefix.getLongestCommonPrefix(input));
    }

    private static String getLongestCommonPrefix(List<String> input) {

        StringBuilder longestCommonPrefix = new StringBuilder();

        char[] firstArrayElement = input.get(0).toCharArray();
        for(int i = 0; i < firstArrayElement.length; i++){
            char currentLetter = firstArrayElement[i];
            for(int j = 1; j < input.size(); j++) {
                String currentWord = input.get(j);


                if(i > currentWord.length()-1 || currentLetter != currentWord.charAt(i)) {
                   return longestCommonPrefix.toString();
                }
            }
            longestCommonPrefix.append(currentLetter);
        }
        return longestCommonPrefix.toString();
    }
}
