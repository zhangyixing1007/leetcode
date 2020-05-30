/*
LeetCode Problem No.378:    https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
Author:                     zhangyixing1007
Idea:                       range binary search
Time:                       0 ms, beat 100%
Space:                      45.1 MB, beat 7.69%
*/

class Solution{
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length - 1;
        int left = matrix[0][0], right = matrix[n][n];
        while(left < right){
            int mid = left + (right - left) / 2;
            int count = countNotMoreThanMid(matrix, mid, n);
            if(count < k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    private int countNotMoreThanMid(int[][] matrix, int mid, int n){
        int count = 0;
        int x = 0, y = n;
        while(x <= n && y >= 0){
            if(matrix[y][x] <= mid){
                count += y + 1;
                x++;
            }else{
                y--;
            }
        }
        return count;
    }
}
