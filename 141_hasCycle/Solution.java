/*
LeetCode Problem No.141:    https://leetcode.com/problems/linked-list-cycle/
Author:                     zhangyixing1007
Idea:                       two pointers, fast and slow
Time:                       0 ms, beat 100%
Space:                      36.2MB, beat 99.61%
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
        if(head==null) return false;
        ListNode slow=head, fast=head.next;
        while (slow!=fast){
            if(fast==null||fast.next==null) return false;
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
