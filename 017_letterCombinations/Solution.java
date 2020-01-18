/*
LeetCode Problem No.017:    https://leetcode.com/problems/letter-combinations-of-a-phone-number/
Author:                     zhangyixing1007
Idea:                       recursion (backtrack)
Time:                       1 ms, beat 93.94%
Space:                      35.8 MB, beat 90.66%
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0) 
            return new ArrayList<String>();
        phone = new String[]{"0","1","abc","def","ghi",
                                      "jkl","mno","pqrs","tuv","wxyz"};
        list=new ArrayList<>();
        
        int c=Character.getNumericValue(digits.charAt(0));
        int len=phone[c].length();
        for (int i=0; i<len; i++){            
            helper(digits, 1, phone[c].substring(i,i+1));
        }
        return list;
    }
    List<String> list;
    String[] phone;
    void helper(String digits, int digit, String candidate){
        if (digits.length()==digit) {
            list.add(candidate); return;
        } 
        int c=Character.getNumericValue(digits.charAt(digit));
        int len=phone[c].length();
        for (int i=0; i<len; i++){
            helper(digits, digit+1, candidate+phone[c].substring(i,i+1));
        }        
    }
}
