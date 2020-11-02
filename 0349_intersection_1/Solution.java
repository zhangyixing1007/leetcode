/*
LeetCode Problem No.0349:   https://leetcode-cn.com/problems/intersection-of-two-arrays/
Author:                     zhangyixing1007
Idea:                       stream()
Time:                       23 ms, beat 6.13%
Space:                      38.9 MB, beat 61.23%
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // int[] 转为 List<Integer>
        List<Integer> l1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        // 过滤，只保留交集元素，去重，自动装箱，转化为List<Integer>
        List<Integer> l2 = Arrays.stream(nums2).filter(n -> l1.contains(n)).distinct()
                .boxed().collect(Collectors.toList());
        // List<Integer> 转为 int[]
        return l2.stream().mapToInt(Integer::valueOf).toArray();
    }
}
