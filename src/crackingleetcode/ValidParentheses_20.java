package crackingleetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * @author Haoming Chen
 * Created on 2019/12/28
 */
public class ValidParentheses_20 {

    public static void main(String[] args) {
//        String ps = "a";
//        String ps = "d";
//        String ps = "e";
//        String ps = "1";
//        String ps = "2";
        String ps = "9";
        if ('0' >= ps.toCharArray()[0] || ps.toCharArray()[0] <= '9') {
            System.out.println(true);
            System.out.println(ps);
        }
    }

    public boolean isValid(String s) {
        if (s == null || s == "") {
            return false;
        }
        char[] strArray = s.toCharArray();
        //push elements to stack
        Stack<Character> stack = new Stack<>();
        for (char i : strArray) {
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) return false;
                if (i == ']') {
                    if ('[' != stack.peek()) return false;
                } else if (i == ')') {
                    if ('(' != stack.peek()) return false;
                } else if (i == '}') {
                    if ('{' != stack.peek()) return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
