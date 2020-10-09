/*
LeetCode Problem No.0141:   https://leetcode.com/problems/linked-list-cycle/
Author:                     zhangyixing1007
Idea:                       two pointers, fast and slow
Time:                       0 ms, beat 100%
Space:                      34.8MB, beat 34.47%
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
        if(head==null||head.next==null) return false;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            head=head.next;
            fast=fast.next.next;
            if(head==fast) return true;
        }
        return false;
    }
}
