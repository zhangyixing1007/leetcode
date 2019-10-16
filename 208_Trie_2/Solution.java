/*
LeetCode Problem No.208:    https://leetcode.com/problems/implement-trie-prefix-tree/
Author:                     zhangyixing1007
Idea:                       TrieNode, TrieNode[] as pointer
Time:                       100 ms, beat 94.11%
Space:                      50.2 MB, beat 99.16%
*/

class Trie 
{
    
    class TrieNode
    {
        boolean end = false;
        TrieNode[] next = new TrieNode[26];
        
        private TrieNode(){}
        
        private TrieNode add(char c)
        {
            int k = c-'a';
            if(next[k]==null) next[k] = new TrieNode();
            return next[k];
        }
        
        private TrieNode get(char c)
        {return next[c-'a'];  }                 
    }

    /** Initialize your data structure here. */
    public Trie() 
    {
        root = new TrieNode();
    }
    
    private TrieNode root;
    
    /** Inserts a word into the trie. */
    public void insert(String word) 
    {
        TrieNode head = root;
        for (char c:word.toCharArray())
        {
            head = head.add(c);
        }
        head.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
        TrieNode head = root;
        for (char c : word.toCharArray())
        {
            head = head.get(c);
            if (head == null) return false;
        }
        return head.end;        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) 
    {
        TrieNode head = root;
        for (char c:prefix.toCharArray())
        {
            head = head.get(c);
            if (head == null) return false;
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
