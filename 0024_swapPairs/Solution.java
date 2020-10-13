/*
LeetCode Problem No.0024:   https://leetcode-cn.com/problems/swap-nodes-in-pairs/
Author:                     zhangyixing1007
Idea:                       select and reconnect
Time:                       0 ms, beat 100%
Space:                      36.2 MB, beat 95.66%
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode first=head, second=head.next, next=second.next;
        ListNode prev=new ListNode(0);
        prev.next=head; head=prev;
        while(true){
            prev.next=second;
            second.next=first;
            first.next=next;
            prev=first;
            if(prev.next!=null && prev.next.next!=null){
                first=prev.next;
                second=first.next;
                next=second.next;
            }else{
                break;
            }
        }
        return head.next;
    }
}
