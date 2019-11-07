/*
LeetCode Problem No.023:    https://leetcode.com/problems/merge-k-sorted-lists/
Author:                     zhangyixing1007
Idea:                       divide-and-conquer algorithm 
Time:                       2 ms, beat 100%
Space:                      40.7 MB, beat 82.15%
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
        if (lists.length == 0)
            return null;
        return startMergeLists(lists, 0, lists.length-1);
    }
    
    private ListNode startMergeLists(ListNode[] lists, int left, int right){
        if (left == right) 
            return lists[left];
        int mid = (left+right)/2;
        ListNode l1 = startMergeLists(lists, left, mid);
        ListNode l2 = startMergeLists(lists, mid+1, right);
        return merge2Lists(l1,l2);
    }
    
    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode prev = new ListNode(0);
        ListNode curr = prev;
        while (l1!=null && l2!=null){
            if (l1.val < l2.val){
                curr.next = l1; 
                l1 = l1.next;
            } else {
                curr.next = l2; 
                l2 = l2.next;                
            }
            curr = curr.next; 
        }
        curr.next = l1 == null? l2:l1;
        return prev.next;
    }
}
