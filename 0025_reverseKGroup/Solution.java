/*
LeetCode Problem No.0025:   https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
Author:                     zhangyixing1007
Idea:                       select, reverse, reconnect
Time:                       0 ms, beat 100%
Space:                      39.2 MB, beat 16.76%
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        int count=0;
        ListNode prev=new ListNode(0); prev.next=head;
        while(count<k-1 && head!=null){
            head=head.next; count++;
        }
        if(count<k-1) return head;
        
        ListNode first=prev.next, last=head, next=last.next;
        head=prev;
        prev.next=null; last.next=null;
        while(true){
            reverse(first);
            prev.next=last;
            first.next=next;
            prev=first;
            first=prev.next;
            last=prev.next;
            count=0;
            while(count<k-1 && last!=null){
                last=last.next; count++;
            }
            if(last==null) return head.next;
            next=last.next;
            prev.next=null; last.next=null;
        }
    }
    void reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode t=head.next;
            head.next=prev;
            prev=head;
            head=t;
        }
    }
}
