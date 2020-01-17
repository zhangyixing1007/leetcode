/*
LeetCode Problem No.155:    https://leetcode.com/problems/min-stack/
Author:                     zhangyixing1007
Idea:                       add an assistant "synchronous" stack
Time:                       8 ms, beat 79.32%
Space:                      40.8 MB, beat 20.26%
*/

class MinStack {

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }
    
    Stack<Integer> stack;
    Stack<Integer> helper;
        
    public void push(int x) {
        stack.push(x);
        if (helper.isEmpty()) helper.push(x);
        else helper.push(Math.min(helper.peek(),x));
    }
    
    public void pop() {
        if (!stack.isEmpty()){
            stack.pop();
            helper.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return helper.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
