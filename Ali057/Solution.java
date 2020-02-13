/*
https://developer.aliyun.com/coding/57
@zhangyixing1007
int[] as record
33ms
71kb
*/

//package solution57;
class Solution {
    public Solution(){}
    public long solution(int n, int k, int[] x) {
      int ans=0;
      int[] record=new int[n+1];
      for(int i=1; i<n+1; i++){
        record[i]=record[i-1]+x[i-1];
      }
      
      for(int j=0; j<n+1; j++){
        for(int i=j; i<n+1; i++){    
          if(record[i]-record[j]>=k) {
            ans+=n-i+1;
            break;
            }
        }
      }      
      return ans;
    }
    
    public static void main(String[] args){
      Solution s=new Solution();
      System.out.println(s.solution(3,5,new int[]{2,3,5}));
      System.out.println(s.solution(4,5,new int[]{2,3,4,5}));
      System.out.println(s.solution(6,5,new int[]{1,2,3,4,5,6}));
    }
}
