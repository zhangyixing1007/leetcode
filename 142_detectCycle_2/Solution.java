/*
LeetCode Problem No.142:    https://leetcode.com/problems/linked-list-cycle-ii/
Author:                     zhangyixing1007
Idea:                       two pointers to check loop, and then Floyd Algorithm 
Time:                       0 ms, beat 100%
Space:                      36.1 MB, beat 5.03%
*/

/**
* Definition for singly-linked list.
* class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) {
*         val = x;
*         next = null;
*     }
* }
*/

public class Solution{
    public ListNode detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast==null||fast.next==null) return null;
        slow = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
