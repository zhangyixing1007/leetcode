/*
LeetCode Problem No.328:    https://leetcode-cn.com/problems/odd-even-linked-list/
Author:                     zhangyixing1007
Idea:                       simple iteration
Time:                       0 ms, beat 100%
Space:                      38.8 MB, beat 8.70%
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode l1=head, l2=head.next, head2=l2;
        while(true){;
            l1.next=l2.next; if(l2.next!=null) l1=l1.next; else break;
            l2.next=l1.next; if(l1.next!=null) l2=l2.next; else break; 
        }
        l1.next=head2;
        return head;
    }
}
