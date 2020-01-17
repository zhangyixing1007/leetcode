/*
LeetCode Problem No.206:    https://leetcode.com/problems/reverse-linked-list/
Author:                     zhangyixing1007
Idea:                       prev = null, two pointers, move
Time:                       0 ms, beat 100%
Space:                      36.7MB, beat 54.36%
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        while(head!=null){
            ListNode tmp=head.next;
            head.next=prev;
            prev=head;
            head=tmp;
        }
        return prev;
    }
}

