/*
LeetCode Problem No.117:    https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
Author:                     zhangyixing1007
Idea:                       using new links
Time:                       0 ms, beat 100%
Space:                      38.8 MB, beat 11.85%
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    Node prev=null;
    Node nextStart=null;
    public Node connect(Node root) {
        if(root==null) return root;
        Node start=root;
        while(start!=null){
            prev=null;
            nextStart=null;
            for(; start!=null; start=start.next){
                if(start.left!=null){
                    connectHelper(start.left);
                }
                if(start.right!=null){
                    connectHelper(start.right);
                }
            }
            start=nextStart;
        }
        return root;
    }
    void connectHelper(Node curr){
        if(prev!=null){
            prev.next=curr;
        }
        if(nextStart==null){
            nextStart=curr;
        }
        prev=curr;
    }
}
