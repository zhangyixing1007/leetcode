/*
LeetCode Problem No.1019:   https://leetcode.com/problems/next-greater-node-in-linked-list/
Author:                     zhangyixing1007
Idea:                       monotone Stack
Time:                       28 ms, beat 62.52%
Space:                      46.5MB, beat 12.50%
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
    public int[] nextLargerNodes(ListNode head) {
        Stack stack=new Stack();
        List<Integer> res=new ArrayList<>();
        List<Integer> data=new ArrayList<>();
        int len=0;
        while(head!=null){            
            res.add(0);
            data.add(head.val);
            while(!stack.isEmpty()&&
              data.get((Integer)stack.peek())<head.val){
                res.set((Integer)stack.peek(),head.val);
                stack.pop();
            }
            head=head.next;
            stack.push(len);
            len++;
        }
        int[] ans=new int[len];
        for(int i=0; i<len; i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}
