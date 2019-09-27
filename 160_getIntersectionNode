/*
LeetCode Problem No.160:    https://leetcode.com/problems/intersection-of-two-linked-lists/
Author:                     zhangyixing1007
Idea:                       a+b = b+a, A end -> B beginning, B end -> A beginning
Time:                       2 ms, beat 94.22%
Space:                      38.6MB, beat 84.07%
*/


/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) {
*         val = x;
*         next = null;
*     }
* }
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null||headB == null) return null;
        ListNode A = headA; ListNode B = headB;
        while(headA!=headB)
        {
            headA = headA == null? B:headA.next;
            headB = headB == null? A:headB.next;
        }
        return headA;
    }
}
