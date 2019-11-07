/*
LeetCode Problem No.023:    https://leetcode.com/problems/merge-k-sorted-lists/
Author:                     zhangyixing1007
Idea:                       brute force
Time:                       513 ms, beat 5.17%
Space:                      56.8 MB, beat 12.75%
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
    public ListNode mergeKLists(ListNode[] lists) {        
        int len = lists.length;
        if (len == 0) return null;
        else if (len == 1) return lists[0];
        ListNode min = null;
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        while (true){
            int id = -1;
            for (int i = 0; i < len; i++){
                if (min == null && lists[i]!=null)
                    min = lists[i];                
                ListNode curr = lists[i];
                if (curr!=null && curr.val <= min.val){
                    min = curr; id = i;
                }                    
            }
            if (id != -1){
                head.next = min; head = head.next;
                min = null; lists[id] = lists[id].next;
            } else break;
        }
        return prev.next;
    }
}
