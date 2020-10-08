  
/*
LeetCode Problem No.0459:   https://leetcode-cn.com/problems/repeated-substring-pattern/
Author:                     zhangyixing1007
Idea:                       KMP
Time:                       20 ms, beat 61.77%
Space:                      39.2 MB, beat 72.26%
*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return kmp(s+s, s);
    }
    boolean kmp(String s, String t){
        int n=s.length();
        int m=t.length();
        int[] fail=new int[m];
        Arrays.fill(fail, -1);
        //比较t[1,:]和t[0,:]自身
        for(int i=1, j=-1; i<m; i++){
            while(j!=-1 && t.charAt(i)!=t.charAt(j+1)) j=fail[j];//回退
            if(t.charAt(i)==t.charAt(j+1)) j++;//比较
            fail[i]=j;//记录 如果在i处摔倒了应在j处爬起来
        }
        //比较s和t
        for(int i=1, j=-1; i<n-1; i++){
            while(j!=-1 && s.charAt(i)!=t.charAt(j+1)) j=fail[j];//回退
            if(s.charAt(i)==t.charAt(j+1)) j++;//比较
            if(j==m-1) return true;//检查 是否已经把t字符串比较完毕
        }
        return false;
    }
}
