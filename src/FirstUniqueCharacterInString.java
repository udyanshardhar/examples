import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Optional;

public class FirstUniqueCharacterInString {
    // 387
    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterInString().findFirstUniqueChar("leetCode"));
        System.out.println(new FirstUniqueCharacterInString().findFirstUniqueChar("loveleetCode"));
    }

    private int findFirstUniqueChar(String input) {
        LinkedHashMap<Character, Integer> record = new LinkedHashMap<>();
        for(int index = 0; index < input.length(); index++){
           char key = input.charAt(index);
           if(record.get(key) == null){
               record.put(key, 1);
           }else {
               record.put(key, record.get(key)+1);
           }
       }

        Optional<Character> first = record.keySet().stream().filter(p -> record.get(p) == 1).findFirst();
       return first.isPresent() ? input.indexOf(first.get()) : -1;
    }
}
