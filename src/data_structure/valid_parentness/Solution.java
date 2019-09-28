package data_structure.valid_parentness;

import java.util.Stack;

/**
 * @author 58212
 * @date 2019-09-28 20:27
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '{' || currentChar == '[' || currentChar == '(') {
                stack.push(currentChar);
            } else {
                //意味着栈中括号已匹配完, 而待匹配括号进入
                if(stack.empty()){
                    return false;
                }
                char topChar = stack.peek();
                if (currentChar == '}' && topChar != '{') {
                    return false;
                }
                if (currentChar == ']' && topChar != '[') {
                    return false;
                }
                if (currentChar == ')' && topChar != '(') {
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
