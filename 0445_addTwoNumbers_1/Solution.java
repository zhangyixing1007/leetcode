/*
LeetCode Problem No.445:    https://leetcode.com/problems/add-two-numbers-ii/
Author:                     zhangyixing1007
Idea:                       StringBuilder, similar to 002
Time:                       13 ms, beat 5.96%
Space:                      40.3 MB, beat 95.83%
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
        StringBuilder v1=new StringBuilder();
        StringBuilder v2=new StringBuilder();
        while(l1!=null){
            v1.append(l1.val+""); l1=l1.next;
        }
        while(l2!=null){
            v2.append(l2.val+""); l2=l2.next;
        }        
        String s1=v1.toString();
        String s2=v2.toString();
        ListNode p=new ListNode(0);
        int i=0;
        int carry=0;
        while(i<Math.max(s1.length(),s2.length()a)){
            int n1=i<s1.length()? Integer.parseInt(s1.substring(s1.length()-1-i, s1.length()-i)):0;
            int n2=i<s2.length()?Integer.parseInt(s2.substring(s2.length()-1-i, s2.length()-i)):0;
            int sum=n1+n2+carry;
            carry=sum/10;
            ListNode q=new ListNode(sum%10);
            q.next=p.next;
            p.next=q;
            i++;
        }
        ListNode q;
        if(carry==1) {
            q=new ListNode(carry);
            q.next=p.next; p.next=q;
        }
        return p.next==null? p:p.next;
    }
}
