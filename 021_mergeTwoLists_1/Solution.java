/*
LeetCode Problem No.021:    https://leetcode.com/problems/merge-two-sorted-lists/
Author:                     zhangyixing1007
Idea:                       prev ListNode
Time:                       1 ms, beat 84.73%
Space:                      35.9 MB, beat 91.96%
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev=new ListNode(-1);
        ListNode l=prev;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                l.next=l1; l1=l1.next;
            } else {
                l.next=l2; l2=l2.next;
            }         
            l=l.next;
        }
        l.next=l1==null?l2:l1;
        return prev.next;
    }
}
