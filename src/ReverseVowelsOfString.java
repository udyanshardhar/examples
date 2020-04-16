import learn.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowelsOfString {
    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfString().reverse("hello"));
        System.out.println(new ReverseVowelsOfString().reverse("leetcode"));
    }

    private String reverse(String s) {
        char[] in = s.toCharArray();
        int startIndex = 0;
        int lastIndex = s.length()-1;
        while (startIndex <= lastIndex){
            if(isVowel(in[startIndex]) && isVowel(in[lastIndex])){
                char temp = in[lastIndex];
                in[lastIndex] =in[startIndex];
                in[startIndex] = temp;
                startIndex ++;
                lastIndex--;
            }else{
                if(!isVowel(in[startIndex]))
                    startIndex++;
                if(!isVowel(in[lastIndex]))
                    lastIndex--;
            }

        }
        String result = "";
        for(char ch : in){
            result = result + ch;
        }
        return result;
    }

    private boolean isVowel(char c) {
        List<Character> vowels = List.of('a', 'i', 'o', 'u', 'e');
        return vowels.contains(c);
    }
}
