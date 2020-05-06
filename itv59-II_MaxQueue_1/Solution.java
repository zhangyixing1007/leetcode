/*
LeetCode Problem itv59-II： https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
Author:                     zhangyixing1007
Idea:                       PriorityQueue
Time:                       47 ms, beat 33.42%
Space:                      48.4 MB, beat 100%
*/

class MaxQueue {

    public MaxQueue() {
        pq=new PriorityQueue<Integer>((o1,o2)->o2-o1);
        q=new LinkedList<Integer>();
    }

    PriorityQueue<Integer> pq;
    Queue<Integer> q;
    
    public int max_value() {
        if(pq.isEmpty()) return -1;
        return pq.peek();
    }
    
    public void push_back(int value) {
        pq.add(value);
        q.add(value);
    }
    
    public int pop_front() {
        if(pq.isEmpty()) return -1;
        int ans=q.poll();
        pq.remove(ans);
        return ans;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
