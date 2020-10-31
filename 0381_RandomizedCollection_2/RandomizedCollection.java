/*
LeetCode Problem No.0381:   https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
Author:                     zhangyixing1007
Idea:                       int[] + HashMap<Integer, List<Integer>>
Time:                       13 ms, beat 94.96%
Space:                      44.5 MB, beat 78.24%
*/

class RandomizedCollection {
    Map<Integer, List<Integer>> map=new HashMap<>();
    int[] nums=new int[10000];
    int size=0;

    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean flag=true;
        if(map.containsKey(val)) flag=false;
        nums[size++]=val;
        List<Integer> list=map.getOrDefault(val, new ArrayList<Integer>());
        list.add(size-1);
        map.put(val, list);
        return flag;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        Iterator<Integer> it=map.get(val).iterator();
        int pos=it.next();
        map.get(val).remove((Integer) pos);
        if(pos!=size-1){
            nums[pos]=nums[size-1];
            List<Integer> list=map.get(nums[pos]);
            list.remove((Integer)(size-1));
            list.add(pos);
            map.put(nums[pos], list);
        }
        if(map.get(val).size()==0) map.remove(val);
        size--;
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums[(int) (Math.random()*size)];
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
