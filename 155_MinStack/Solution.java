/*
LeetCode Problem No.155:    https://leetcode.com/problems/min-stack/
Author:                     zhangyixing1007
Idea:                       add an assistant stack, each element being the smallest element so far
Time:                       69 ms, beat 96.92%
Space:                      40.2MB, beat 95.58%
*/

class Solution {


    private Stack<Integer> data;
    private Stack<Integer> helper;
    
    public MinStack() {
        data = new Stack<>();        
        helper = new Stack<>();
    }
    
    public void push(int x) {
        data.push(x);
        
        if (helper.isEmpty() || x <= helper.peek())
        {helper.push(x);}
    }
    
    public void pop() {  
        if (!data.isEmpty())
        {
            int x = data.pop();
            if (x == helper.peek())
            {helper.pop();}
        }
    }
    
    public int top() {
        if (!data.isEmpty())
            return data.peek();
        throw new NullPointerException("No elements in the MinStack!");
    }
    
    public int getMin() {
        if (!helper.isEmpty())
            return helper.peek();
        throw new NullPointerException("No elements in the MinStack!");
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
