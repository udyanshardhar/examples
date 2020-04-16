package learn;

import java.util.HashMap;
import java.util.Map;

public class FindDifference {
    public static void main(String[] args) {
        System.out.println(new FindDifference().find("aaa", "abaa"));
    }

    private String find(String first, String second) {
        Map<Character, Integer> result = new HashMap<>();

        for(char ch :first.toCharArray()){
            result.merge(ch, 1, Integer::sum);
        }

        for(char ch :second.toCharArray()){
            if(result.get(ch) == null || result.get(ch) == 0 ){
                return String.valueOf(ch);
            }else {
                result.put(ch, result.get(ch)-1);
            }
        }
        return "";
    }
}
