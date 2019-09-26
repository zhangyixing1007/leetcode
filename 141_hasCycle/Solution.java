/*
LeetCode Problem No.141:    https://leetcode.com/problems/linked-list-cycle/
Author:                     zhangyixing1007
Idea:                       two pointers, fast and slow
Time:                       0 ms, beat 100%
Space:                      37.5MB, beat 96.69%
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

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (head!=null)
        {
            if (fast == null||fast.next==null) return false;
            else if (fast.next != null) fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
