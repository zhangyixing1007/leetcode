/*
LeetCode Problem No.394:    https://leetcode.com/problems/decode-string/
Author:                     zhangyixing1007
Idea:                       two LinkedList
Time:                       2 ms, beat 67.53%
Space:                      34.3 MB, beat 92.61%
*/

class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int mul = 0;
        LinkedList<Integer> muls = new LinkedList<>();
        LinkedList<String> strs = new LinkedList<>();
        for (Character c : s.toCharArray()){
            if (c >= '0' && c <='9'){
                mul = mul*10 + Integer.parseInt(c+"");//!
            } else if (c == '[') {
                muls.addLast(mul); mul = 0;
                strs.addLast(res.toString()); res = new StringBuilder();
            } else if (c == ']') {
                mul = muls.removeLast();
                StringBuilder tmp = new StringBuilder();
                while (mul>0){
                    tmp.append(res); mul--;
                }
                res = new StringBuilder(strs.removeLast()+tmp);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
