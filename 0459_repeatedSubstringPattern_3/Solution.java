  
/*
LeetCode Problem No.0459:   https://leetcode-cn.com/problems/repeated-substring-pattern/
Author:                     zhangyixing1007
Idea:                       optimized KMP
Time:                       11 ms, beat 87.81%
Space:                      39.4 MB, beat 27.78%
*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return kmp(s);
    }
    boolean kmp(String s){
        int n=s.length();
        int[] fail=new int[n];
        Arrays.fill(fail, -1);
        //比较s[1,:]和s[0,:]自身
        for(int i=1, j=-1; i<n; i++){
            while(j!=-1 && s.charAt(i)!=s.charAt(j+1)) j=fail[j];//回退
            if(s.charAt(i)==s.charAt(j+1)) j++;//比较
            fail[i]=j;//记录 如果在i处摔倒了应在j处爬起来
        }
        return fail[n-1]!=-1 && n%(n-fail[n-1]-1)==0;
    }
}
