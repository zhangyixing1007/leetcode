/*
LeetCode Problem No.160:    https://leetcode.com/problems/intersection-of-two-linked-lists/
Author:                     zhangyixing1007
Idea:                       a+b = b+a, A end -> B beginning, B end -> A beginning
Time:                       1 ms, beat 100%
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
        if (headA==null||headB==null) return null;
        ListNode A=headA, B=headB;
        while(A!=B){
            A=A==null? headB:A.next;
            B=B==null? headA:B.next;
        }
        return A;
    }
}
