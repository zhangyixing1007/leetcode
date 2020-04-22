/*
LeetCode Problem No.1019:   https://leetcode.com/problems/next-greater-node-in-linked-list/
Author:                     zhangyixing1007
Idea:                       simpliest, convert to array, two layers of loop
Time:                       514 ms, beat 25.31%
Space:                      42.2MB, beat 12.50%
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
        List<Integer> list=new ArrayList<>();
        if(head==null) return new int[0];
        while(head.next!=null){
            list.add(head.val);
            head=head.next;
        }
        list.add(head.val);
        int n=list.size();
        int[] link=new int[n];
        for(int i=0; i<n; i++){
            link[i]=list.get(i);
        }
        int[] ans=new int[n];
        for(int i=n-2; i>-1; i--){
            boolean flag=false;
            for(int j=i+1; j<n;j++){
                if(link[i]<link[j]){
                    ans[i]=link[j];
                    flag=true;
                    break;
                }
            }
            if(!flag) ans[i]=0;
        }
        return ans;
    }
}
