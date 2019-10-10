/*
LeetCode Problem No.142:    https://leetcode.com/problems/linked-list-cycle-ii/
Author:                     zhangyixing1007
Idea:                       two pointers to check loop, and then Floyd Algorithm 
Time:                       8 ms, beat 31.11%
Space:                      36.2 MB, beat 5.03%
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

public class Solution
{
    public ListNode detectCycle(ListNode head)
    {
        Set<ListNode> set = new HashSet<>();
        while(head!=null&&(set.isEmpty()||!set.contains(head)))
        {
            set.add(head);
            head = head.next;
        }
        return head;
    }
}
