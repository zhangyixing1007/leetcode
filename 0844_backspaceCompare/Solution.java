/*
LeetCode Problem No.0844:   https://leetcode-cn.com/problems/backspace-string-compare/
Author:                     zhangyixing1007
Idea:                       just char[]
Time:                       1 ms, beat 85.73%
Space:                      36.8 MB, beat 22.16%
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
       int len=Math.max(S.length(), T.length());
       int[] schar=new int[len]; int i=0;
       int[] tchar=new int[len];
       for(int j=0; j<S.length(); j++){
           if(S.charAt(j)=='#'){
               i=Math.max(0, i-1);
           }else{
               schar[i++]=S.charAt(j);
           }
       }
       int k=i; i=0;
       for(int j=0; j<T.length(); j++){
           if(T.charAt(j)=='#'){
               i=Math.max(0, i-1);
           }else{
               tchar[i++]=T.charAt(j);
           }
       }
       if(k!=i) return false;
       for(int j=0; j<i; j++){
           if(schar[j]!=tchar[j]){
               return false;
           }
       }
       return true;
    }
}
