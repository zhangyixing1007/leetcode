/*
LeetCode Problem No.0445:   https://leetcode.com/problems/add-two-numbers-ii/
Author:                     zhangyixing1007
Idea:                       modify in longer list
Time:                       2 ms, beat 100%
Space:                      38.9 MB, beat 84.76%
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2; 
        else if(l2==null) return l1;
        int len1=len(l1), len2=len(l2);
        ListNode prev=new ListNode(0);
        if(len1>=len2){
            prev.next=l1;
            addTwoNumbers(l1, l2, len1, len2);
        }else{
            prev.next=l2;
            addTwoNumbers(l2, l1, len2, len1);
        }
        if(prev.next.val>=10){
            prev.next.val=prev.next.val%10;
            prev.val=1; return prev;
        }else{
            return prev.next;
        }
    }
    int carry=0;
    void addTwoNumbers(ListNode l1, ListNode l2, int len1, int len2){
        if(len1==0) return;
        if(len1>len2){
            addTwoNumbers(l1.next, l2, len1-1, len2);
        }else{
            addTwoNumbers(l1.next, l2.next, len1-1, len2-1);
        }
        l1.val += (len1==len2? l2.val:0);
        l1.val += (l1.next==null? 0:l1.next.val/10);
        if(l1.next!=null) l1.next.val=l1.next.val%10;
    }
    int len(ListNode l){
        int len=0;
        while(l!=null){
            len++; l=l.next;
        }
        return len;
    }
}
