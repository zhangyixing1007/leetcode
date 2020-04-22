/*
LeetCode Problem No.61:     https://leetcode.com/problems/rotate-list/submissions/
Author:                     zhangyixing1007
Idea:                       loop and cut (I separate cases here)
Time:                       1 ms, beat 79.01%
Space:                      39.3 MB, beat 5.41%
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0) return head;
        ListNode prev=new ListNode(0);
        prev.next=head;
        int len=0;
        int step=k;
        while(head.next!=null&&step>1) {
            head=head.next; len++;step--;
        }
        ListNode p=prev.next;
        ListNode q=prev;
        if(step==1){
            while(head.next!=null){
                p=p.next;q=q.next;
                head=head.next;                
            }            
            q.next=null;
            head.next=prev.next;
            return p;
        }else{
            len++;
            k=k%len;
            if(k==0) return prev.next;
            k=len-k;
            head.next=prev.next;
            while(k-->0) head=head.next;
            prev=head; head=head.next; prev.next=null;
            return head;
        }
    }
}
