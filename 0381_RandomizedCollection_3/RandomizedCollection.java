/*
LeetCode Problem No.0381:   https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
Author:                     zhangyixing1007
Idea:                       List<Integer> + HashMap<Integer, List<Integer>>
Time:                       17 ms, beat 39.21%
Space:                      45.4 MB, beat 50.00%
*/

class RandomizedCollection {
    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        idx = new HashMap<Integer, Set<Integer>>();
        nums = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
        set.add(nums.size() - 1);
        idx.put(val, set);
        return set.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }
        Iterator<Integer> it = idx.get(val).iterator();  
        // 取出一个符合要求的坐标
        int i = it.next();
        // 取到最后一个元素内容
        int lastNum = nums.get(nums.size() - 1);
        // 将i位置放上最后一个元素的内容（注意 i==nums.size()-1 是有可能的）
        nums.set(i, lastNum);
        idx.get(val).remove(i);
        idx.get(lastNum).remove(nums.size() - 1);
        // 如果i==nums.size()-1不成立 那么就有必要添加lastNum的新位置 i 
        // 否则什么也不用做 因为lastNum的i早已经被删掉了
        if (i < nums.size() - 1) {
            idx.get(lastNum).add(i);
        }
        // 如果val删去一个就没有了，此时就应该从idx中删除val
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }
        // 更新list
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
