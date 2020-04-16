package com.us.solutions.stack;

import java.util.Stack;

public class InfixtoPostFixExperssion {
    static int Prec(Character in){
        switch (in){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;

        }
        return -1;
    }

    static String solution(String input){

        String result = "";
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                result = result + ch;
            }else if(ch == '('){
                stack.push(ch);
            }else if(ch == ')'){
                while ((!stack.isEmpty() && stack.peek() != '(')){
                    result = result + stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression
                else
                    stack.pop();
            }else {
                while (!stack.isEmpty() && Prec(ch) <= Prec(stack.peek())) {
                    result = result + stack.pop();
                }
                stack.push(ch);
            }

        }

        while (!stack.isEmpty()){
            result = result +stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(InfixtoPostFixExperssion.solution(exp));
    }

}
