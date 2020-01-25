/*
LeetCode Problem No.146:    https://leetcode.com/problems/lru-cache/
Author:                     zhangyixing1007
Idea:                       LinkedHashMap
Time:                       75 ms, beat 97.63%
Space:                      50.7 MB, beat 99.67%
*/

class LRUCache extends LinkedHashMap<Integer, Integer>{
    int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity=capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return capacity<size();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
