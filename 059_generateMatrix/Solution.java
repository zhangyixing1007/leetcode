/*
LeetCode Problem No.59:     https://leetcode.com/problems/spiral-matrix-ii/
Author:                     zhangyixing1007
Idea:                       similar to 054
Time:                       0 ms, beat 100%
Space:                      37.4 MB, beat 7.14%
*/

class Solution {
    public int[][] generateMatrix(int n) {
        int ele=1, index=1, i=0, j=0;
        int[][] ans=new int[n][n];
        while(ele<=n*n){
            if(index%4==1){
                for (; j<n-index/4; j++, ele++){
                    ans[i][j]=ele;
                }
                i++; j--;
            }else if(index%4==2){
                for (; i<n-index/4; i++, ele++){
                    ans[i][j]=ele;
                }
                j--;i--;
            }else if(index%4==3){
                for (; j>=0+index/4; j--, ele++){
                    ans[i][j]=ele;
                }
                i--;j++;
            }else if(index%4==0){
                for (; i>=index/4; i--, ele++){
                    ans[i][j]=ele;
                }
                j++;i++;
            }
            index++;
        }
        return ans;
    }
}
