/*
LeetCode Problem No.002:    https://leetcode.com/problems/add-two-numbers/
Author:                     zhangyixing1007
Idea:                       prev ListNode
Time:                       2 ms, beat 99.95%
Space:                      45.3 MB, beat 5.02%
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
        ListNode prev=new ListNode(0), l=prev;
        int carry=0;
        while(l1!=null||l2!=null){
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            int sum=x+y+carry;
            carry=sum/10;
            prev.next=new ListNode(sum%10);
            prev=prev.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if (carry>0) prev.next=new ListNode(carry);
        return l.next;
    }    
}
