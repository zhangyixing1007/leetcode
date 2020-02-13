/*
https://developer.aliyun.com/coding/40
@zhangyixing1007
HashMap
820ms
12917kb
*/

//package solution40;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public Solution(){};    
    public int solution(int n,int[] nums) {      
       Arrays.sort(nums);
       HashMap<Integer,Integer> map=new HashMap<>();
       int ans=0;
       int limit=(int) (Math.log(nums[n-1]*2)/Math.log(2));
      for (int num:nums) {
        map.put(num,map.getOrDefault(num,0)+1);
      }
       for (int num:nums){
         int i=0;
         while(i<limit+1){
           if((int)(Math.pow(2,i)-num)==num&&map.getOrDefault(num,0)<2){
           }
           else if(map.containsKey((int)(Math.pow(2,i)-num))){
             break;
           }
           i++; 
         }
         if(i==limit+1) ans++;
       }
       return ans;
    }
    
    public static void main(String[] args){
//      int n=3;int[] nums=new int[]{1,2,3};
//      int n=1;int[] nums=new int[]{1};
//      int n=1;int[] nums=new int[]{2};           
//      int n=3;int[] nums=new int[]{4,5,6};     
      int n=5;int[] nums=new int[]{2,2,3,4,5}; 
      Solution s=new Solution();
      System.out.println(s.solution(n,nums));
    }
    
}
