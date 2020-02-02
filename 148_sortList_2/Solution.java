/*
LeetCode Problem No.148:    https://leetcode.com/problems/sort-list/
Author:                     zhangyixing1007
Idea:                       merge sort + Floyd Algorithm 
Time:                       4 ms, beat 96.84%
Space:                      39.3 MB, beat 98.65%
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution{
    public ListNode sortList(ListNode head){
        if (head==null||head.next==null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        head = sortList(head);
        curr = sortList(curr);
        
        ListNode pre = new ListNode(0);
        slow = pre;
        while (head!=null&&curr!=null){
            if (head.val<curr.val){
                pre.next = head; pre = pre.next; head = head.next;
            }
            else{
                pre.next = curr; pre = pre.next; curr = curr.next;
            }
        }
        pre.next = head==null? curr:head;
        return slow.next;            
    }
}
