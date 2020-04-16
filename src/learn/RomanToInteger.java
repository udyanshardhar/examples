package learn;

import java.util.HashMap;

public class RomanToInteger {

    public static HashMap<String, Integer>  romanMap = new HashMap<>();
    static {
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);
        romanMap.put("IV", 4);
        romanMap.put("IX",9 );
        romanMap.put("XL", 40);
        romanMap.put("XC", 90);
        romanMap.put("CD", 400);
        romanMap.put("CM", 900);

    }
    public static void main(String[] args) {
        System.out.println(new RomanToInteger().convert("IX"));
        System.out.println(new RomanToInteger().convert("III"));
        System.out.println(new RomanToInteger().convert("IV"));
        System.out.println(new RomanToInteger().convert("LVIII"));
    }

    private int convert(String s) {
         if(s == null || s.trim().length() == 0) {
             return 0;
         }
        char [] in = s.toCharArray();
        if(in.length < 2)
            return romanMap.get(""+in[0]);
        int startIndex = 0;
        int lastIndex = 1 ;
            int result = 0;
        while (startIndex < in.length || lastIndex < s.length()-1){
            if(lastIndex < s.length() && romanMap.containsKey(""+in[startIndex]+in[lastIndex])){
                result = result +romanMap.get(""+in[startIndex]+in[lastIndex]);
                startIndex = lastIndex+1;
                lastIndex = startIndex+1;
            }else {
                result = result +romanMap.get(""+in[startIndex]);
                startIndex++;
                lastIndex ++;
            }
        }
        return result;
    }
}
