/*
LeetCode Problem No.208:    https://leetcode.com/problems/implement-trie-prefix-tree/
Author:                     zhangyixing1007
Idea:                       TrieNode, TrieNode[] as pointer
Time:                       100 ms, beat 94.11%
Space:                      50.2 MB, beat 99.16%
*/

class Trie {
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        boolean end = false;
        TrieNode() {}
        
        TrieNode add(char c){
            int k = c-'a';
            if (next[k] == null) 
                next[k] = new TrieNode();
            return next[k];
        }
        
        TrieNode get(char c){
            return next[c-'a'];
        }
    }
    
    TrieNode root = new TrieNode();
    
    /** Initialize your data structure here. */
    public Trie() {}
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c:word.toCharArray()){
            node = node.add(c);
        }
        node.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c:word.toCharArray()){
            node = node.get(c);
            if (node == null) return false;
        }
        return node.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c:prefix.toCharArray()){
            node = node.get(c);
            if (node == null) return false;
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
