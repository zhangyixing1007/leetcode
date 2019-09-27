/*
LeetCode Problem No.234:    https://leetcode.com/problems/palindrome-linked-list/
Author:                     zhangyixing1007
Idea:                       fast/slow pointers, reverse one half of it and compare, pay attention to odd/even case
Time:                       1 ms, beat 99.89%
Space:                      40.4MB, beat 97.76%
*/

class Solution { 
    public boolean isPalindrome(ListNode head) { 
        if (head==null || head.next==null) return true; 
        if (head.next.next == null) 
            return (head.val==head.next.val); 
         
        int len = 1; 
        ListNode fast = head; 
        ListNode slow = head; 
        while (fast!=null && fast.next!=null && fast.next.next!=null) 
        { 
            fast = fast.next.next; 
            slow = slow.next; len ++;          
        } 
        if (fast.next!=null) 
        {             
            slow = slow.next; 
        } 
        int[] compare = new int[len]; 
        for (int i = 0; i < len; i++) 
        { 
            compare[len-i-1] = slow.val; 
            slow = slow.next; 
        } 
        for (int i = 0; i < len; i++) 
        { 
            if(head.val == compare[i]) 
            {head=head.next;} 
            else 
            {return false;} 
        } 
        return true; 
    } 
} 
