/*
LeetCode Problem No.019:    https://leetcode.com/problems/remove-nth-node-from-end-of-list/
Author:                     zhangyixing1007
Idea:                       fast/slow pointers
Time:                       1 ms, beat 56.92%
Space:                      35.1 MB, beat 11.27%
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev=new ListNode(0);
        prev.next=head;
        ListNode slow=prev, fast=prev;
        while (n>-1){
            fast=fast.next;n--;
        }
        while (fast!=null){
            fast=fast.next; slow=slow.next;
        }
        slow.next=slow.next.next;
        return prev.next;
    }
}
