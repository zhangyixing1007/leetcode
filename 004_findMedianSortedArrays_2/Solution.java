/*
LeetCode Problem No.004:    https://leetcode.com/problems/median-of-two-sorted-arrays/
Author:                     zhangyixing1007
Idea:                       brute force, no new array
Time:                       3 ms, beat 99.42%
Space:                      47 MB, beat 94.72%
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
        
        int count = 0, i = 0, j = 0, left = -1, right = -1;
        
        while (count != (m+n)/2+1){
            left = right;
            if (i<m&&(j == n||nums1[i]<nums2[j])){
                count++; right = nums1[i++]; 
            }
            else{
                count++; right = nums2[j++];
            }
        }
        if ((m+n)%2 == 1) return right;
        return ((double) (left+right))/2;
    }
}
