package learn.str;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solutions {
    public static void main(String args[]) {

        String input = "5!!aaaaaaaaaaaaa!10!5";
        System.out.println(Solutions.findSolution(input));
    }

    private static boolean findSolution(String input) {
        //Pattern pattern = Pattern.compile("-?\\d+([a-z]*![a-z]*![a-z]*!)\\d+");
        Pattern pattern = Pattern.compile("-?\\d+([a-z]*![a-z]*![a-z]*!)\\d+");
        Matcher m = pattern.matcher(input);
        boolean result = false;
        while(m.find()) {
            String found = m.group();
            if(found != null) {
                int lastNumebr = Integer.valueOf(found.substring(found.length()-1));
                int firstNumber = Integer.valueOf(found.substring(0, 1));
                result =  lastNumebr + firstNumber == 15;
            }
        }
        return result;
    }
}
