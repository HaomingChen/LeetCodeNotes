package crackingleetcode;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {

    Stack<Integer> stk;
    int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stk = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stk.push(min);
            min = x;
        }
        stk.push(x);
    }

    public void pop() {
        if (stk.size() == 0) {
            return;
        }
        int val = stk.pop();
        if (val == min) {
            int next = stk.pop();
            min = next;
        }
    }

    public int top() {
        if (stk.size() == 0) {
            return -1;
        }
        return stk.peek();
    }

    public int getMin() {
        if (stk.size() == 0) {
            return -1;
        }
        return min;
    }
}
