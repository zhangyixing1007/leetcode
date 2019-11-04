/*
LeetCode Problem No.004:    https://leetcode.com/problems/median-of-two-sorted-arrays/
Author:                     zhangyixing1007
Idea:                       brute force
Time:                       3 ms, beat 99.42%
Space:                      45.7 MB, beat 98.83%
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            if (n%2 == 1) return nums2[n/2];
            return ((double)(nums2[n/2]+nums2[n/2-1]))/2;
        }
        if (n == 0) {
            if (m%2 == 1) return nums1[m/2];
            return ((double)(nums1[m/2]+nums1[m/2-1]))/2;
        }
        
        int[] nums = new int[m+n];
        int count = 0, i = 0, j = 0;
        
        while (count < m+n){
            if (i<m&&(j == n||nums1[i]<nums2[j]))
                nums[count++] = nums1[i++];
            else
                nums[count++] = nums2[j++];
        }
        if ((m+n)%2 == 1) return nums[(m+n)/2];
        return ((double) (nums[(m+n)/2]+nums[(m+n)/2-1]))/2;
    }
}
