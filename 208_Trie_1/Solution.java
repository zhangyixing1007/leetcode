/*
LeetCode Problem No.208:    https://leetcode.com/problems/implement-trie-prefix-tree/
Author:                     zhangyixing1007
Idea:                       TreeNode, HashMap as pointer
Time:                       114 ms, beat 88.96%
Space:                      51.6 MB, beat 98.32%
*/

class Trie{
    private class TreeNode{
        char ch;
        boolean end;
        Map<Character,TreeNode> map;       
        
        private TreeNode(char c){
            ch = c;
            end = false;
            map = new HashMap<>();
        }
    }
    /** Initialize your data structure here. */
    
    public Trie(){
        root = new TreeNode('#');        
    }
    
    TreeNode root;
    /** Inserts a word into the trie. */
    public void insert(String word){
        TreeNode head = root;
        int i = 0;
        while (i < word.length()){
            char c = word.charAt(i);
            if (head.map.containsKey(c)){
                head = head.map.get(c);
                i++;
            }
            else{
                TreeNode node = new TreeNode(c);
                head.map.put(c,node);
                head = node;
                i++;
            }
        }
        head.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word){
        TreeNode head = root;
        int i = 0;
        while (i < word.length()){
            char c = word.charAt(i);
            if (head.map.containsKey(c)){
                head = head.map.get(c);
                i++;
            }
            else{
                return false;
            }
        }        
        return head.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix){
        TreeNode head = root;
        int i = 0;
        while (i < prefix.length()){
            char c = prefix.charAt(i);
            if (head.map.containsKey(c)){
                head = head.map.get(c);
                i++;
            }
            else{
                return false;
            }
        }      
        return true;
    }
}


/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/
