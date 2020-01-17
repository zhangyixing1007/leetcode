/*
LeetCode Problem No.234:    https://leetcode.com/problems/palindrome-linked-list/
Author:                     zhangyixing1007
Idea:                       fast/slow pointers, reverse the rest 1/2 
Time:                       1 ms, beat 99.89%
Space:                      40.4MB, beat 97.76%
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true; 
        ListNode prev=null;
        ListNode slow=head, fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        if (fast!=null) slow=slow.next;
        while(slow!=null){
            ListNode tmp=slow;
            slow=slow.next;
            tmp.next=prev;
            prev=tmp;
        }
        slow=prev;fast=head;
        while(slow!=null){
            if(slow.val==fast.val){slow=slow.next; fast=fast.next;}
            else return false;
        }
        return true;
    }
}
