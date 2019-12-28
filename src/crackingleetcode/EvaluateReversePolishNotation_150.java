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
        Stack<String> calStk = new Stack<>();
        String res;
        for (String item : tokens) {
            if (judgeIfInt(item)) {
                calStk.push(item);
            } else {
                String val1 = calStk.pop();
                String val2 = calStk.pop();
                //do calculate
                if (item.equals("+")) {
                    res = Integer.toString(Integer.parseInt(val1) + Integer.parseInt(val2));
                } else if (item.equals("-")) {
                    res = Integer.toString(Integer.parseInt(val2) - Integer.parseInt(val1));
                } else if (item.equals("*")) {
                    res = Integer.toString(Integer.parseInt(val1) * Integer.parseInt(val2));
                } else {
                    //note: numbers order matters at this case, the number that follows up the
                    // first pop number should be divider. e.g [1,2,/] -> pop 2, pop 1 -> 1 / 2
                    res = Integer.toString(Integer.parseInt(val2) / Integer.parseInt(val1));
                }
                calStk.push(res);
            }
        }
        return Integer.parseInt(calStk.pop());
    }

    private static boolean judgeIfInt(String item) {
        try {
            Integer.parseInt(item);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
