/*
LeetCode Problem No.54:     https://leetcode.com/problems/spiral-matrix/
Author:                     zhangyixing1007
Idea:                       define direction and limit by "index"
Time:                       0 ms, beat 100%
Space:                      37.3 MB, beat 5.72%
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null) return new ArrayList<>();        
        if(matrix.length==0||matrix[0].length==0) return new ArrayList<>();
        int n=matrix.length, m=matrix[0].length;
        List<Integer> list=new ArrayList<>();
        int index=1, i=0, j=0;
        while(list.size()<m*n){
            if(index%4==1){
                for(;j<m-index/4;j++){
                    list.add(matrix[i][j]);
                }
                i++;j--;
            }else if(index%4==2){
                for(;i<n-index/4;i++){
                    list.add(matrix[i][j]);
                }
                j--;i--;                
             }else if(index%4==3){
                for(;j>=0+index/4;j--){
                    list.add(matrix[i][j]);
                }
                i--;j++;  
            }else if(index%4==0){
                for(;i>=0+index/4;i--){
                    list.add(matrix[i][j]);
                }
                j++;i++;
            }            
            index++;
        }
        return list;
    }
}
