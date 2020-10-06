/*
LeetCode Problem No.0002:   https://leetcode.com/problems/add-two-numbers/
Author:                     zhangyixing1007
Idea:                       mind carry
Time:                       3 ms, beat 22.15%
Space:                      38.8 MB, beat 85.56%
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode prev=new ListNode(0);
        ListNode head=prev;
        int carry=0, num1=0, num2;
        while(l1!=null||l2!=null){
            num1=l1==null? 0:l1.val;
            num2=l2==null? 0:l2.val;
            carry+=num1+num2;
            head.next=new ListNode(carry%10);
            carry/=10;
            if(l1!=null) l1=l1.next; 
            if(l2!=null) l2=l2.next; 
            head=head.next;
        }
        if(carry!=0){
            head.next=new ListNode(carry);
        }
        return prev.next;
    }
}
