/*
LeetCode Problem No.341:    https://leetcode-cn.com/problems/flatten-nested-list-iterator/
Author:                     zhangyixing1007
Idea:                       recursion, ArrayList
Time:                       3 ms, beat 99.98%
Space:                      41.8 MB, beat 33.33%
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int id=0;
    public NestedIterator(List<NestedInteger> nestedList) {
        list=IntegerIterator(nestedList);
    }
    
    List<Integer> IntegerIterator(List<NestedInteger> nestedList){
        List<Integer> l=new ArrayList<>();
        for(NestedInteger i:nestedList){
            if(i.isInteger()) l.add(i.getInteger());
            else l.addAll(IntegerIterator(i.getList()));
        }
        return l;
    }

    @Override
    public Integer next() {
        return id<list.size()? list.get(id++):null;
    }

    @Override
    public boolean hasNext() {
        return id!=list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
