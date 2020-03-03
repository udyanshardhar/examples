package learn;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("String is valid : "+ ValidParentheses.isValidParenthisis("{{}}"));

    }

    private static boolean isValidParenthisis(String input) {
        Stack<Character>  tempSTack = new Stack<>();
        for(char ch : input.toCharArray()){
            if(ch == '{' | ch == '(' | ch == '[') {
                tempSTack.push(ch);
            }else if(ch == '}' && tempSTack.peek() == '{') {
                tempSTack.pop();
            }else if(ch == ')' && tempSTack.peek() == '(') {
                tempSTack.pop();
            }else if(ch == ']' && tempSTack.peek() == '[') {
                tempSTack.pop();
            }
        }
        return tempSTack.isEmpty();
    }
}
