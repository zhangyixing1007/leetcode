
/*
LeetCode Problem No.5518:   https://leetcode-cn.com/problems/find-valid-matrix-given-row-and-column-sums/
Author:                     zhangyixing1007
Idea:                       Math.min(rowSum[i], colSum[j])
Time:                       10 ms
Space:                      46.6 MB
*/

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n=rowSum.length;
        int m=colSum.length;
        int[][] ans=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans[i][j]=Math.min(rowSum[i], colSum[j]);
                rowSum[i]-=ans[i][j];
                colSum[j]-=ans[i][j];
            }
        }
        return ans;
    }
}
