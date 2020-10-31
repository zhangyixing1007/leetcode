/*
LeetCode Problem No.0380:   https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
Author:                     zhangyixing1007
Idea:                       int[] + HashMap<Integer, Integer>
Time:                       11 ms, beat 98.75%
Space:                      42.8 MB, beat 95.25%
*/

class RandomizedSet {

    Map<Integer, Integer> map=new HashMap<>();
    int[] nums=new int[10000];
    int size=0;
    /** Initialize your data structure here. */
    public RandomizedSet() {

    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        nums[size++]=val;
        map.put(val, size-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int pos=map.remove(val);
        if(pos!=size-1){
            nums[pos]=nums[size-1];
            map.put(nums[pos], pos);
        }
        size--;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums[(int) (Math.random()*size)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
