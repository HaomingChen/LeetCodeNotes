package crackingleetcode;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * @author Haoming Chen
 * Created on 2019/12/28
 */
public class EvaluateReversePolishNotation_150 {

    public static void main(String[] args) {
//        String[] arr = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] arr = new String[]{"22"};
        System.out.println(evalRPN(arr));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<String> stk = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            int res;
            if (tokens[i].equals("+")) {
                res = Integer.parseInt(stk.pop()) + Integer.parseInt(stk.pop());
            } else if (tokens[i].equals("-")) {
                res = -Integer.parseInt(stk.pop()) + Integer.parseInt(stk.pop());
            } else if (tokens[i].equals("*")) {
                res = Integer.parseInt(stk.pop()) * Integer.parseInt(stk.pop());
            } else if (tokens[i].equals("/")) {
                int divisor = Integer.parseInt(stk.pop());
                res = Integer.parseInt(stk.pop()) / divisor;
            } else {
                res = Integer.parseInt(tokens[i]);
            }
            stk.push(Integer.toString(res));
        }
        return Integer.parseInt(stk.pop());
    }

}
