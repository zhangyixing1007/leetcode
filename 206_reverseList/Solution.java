/*
LeetCode Problem No.206:    https://leetcode.com/problems/reverse-linked-list/
Author:                     zhangyixing1007
Idea:                       prev = null, two pointers, move
Time:                       0 ms, beat 100%
Space:                      36.7MB, beat 54.36%
*/

class Solution { 
    public ListNode reverseList(ListNode head) { 
        if (head == null) return null; 
         
        ListNode prev = null, curr = head, next = head.next;         
        while(next!=null) 
        { 
            curr.next = prev; 
            prev = curr; curr = next; next = next.next; 
        } 
        curr.next = prev; 
        return curr; 
    } 
} 
