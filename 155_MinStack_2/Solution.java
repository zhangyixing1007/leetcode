/*
LeetCode Problem No.155:    https://leetcode.com/problems/min-stack/
Author:                     zhangyixing1007
Idea:                       add an assistant "unsynchronous" stack
Time:                       69 ms, beat 96.92%
Space:                      40.2MB, beat 95.58%
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
        if (helper.isEmpty()||helper.peek()>=x) 
            helper.push(x);
    }
    
    public void pop() {
        if (!stack.isEmpty()){
            int t=stack.pop();
            if (t==helper.peek())
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
