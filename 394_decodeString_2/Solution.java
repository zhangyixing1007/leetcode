/*
LeetCode Problem No.394:    https://leetcode.com/problems/decode-string/
Author:                     zhangyixing1007
Idea:                       two Stacks
Time:                       1 ms, beat 93.55%
Space:                      34.5 MB, beat 48.33%
*/

class Solution {
    public String decodeString(String s) {
        StringBuilder ans=new StringBuilder();
        Stack<Integer> muls=new Stack<>();
        Stack<String> strs=new Stack<>();
        int mul=0;
        for (char c:s.toCharArray()){
            if(c>='0'&&c<='9'){
                mul=mul*10+Integer.parseInt(c+"");
            } else if (c=='['){
                muls.push(mul);mul=0;
                strs.push(ans.toString());
                ans=new StringBuilder();
            } else if (c==']'){
                StringBuilder tmp=new StringBuilder();
                mul=muls.pop();
                while(mul>0){
                    tmp.append(ans);
                    mul--;
                }
                ans=new StringBuilder(strs.pop()+tmp.toString());
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
