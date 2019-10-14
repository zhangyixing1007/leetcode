/*
LeetCode Problem No.146:    https://leetcode.com/problems/lru-cache/
Author:                     zhangyixing1007
Idea:                       HashMap + DlinkedNode + DlinkedList
Time:                       81 ms, beat 94.27%
Space:                      57.4 MB, beat 95.45%
*/


class LRUCache 
{

    private class DlinkedNode
    {
        int key;
        int val;
        DlinkedNode prev;
        DlinkedNode next;   
        
        private DlinkedNode(int key, int val)
        {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
            
    }
    
    private class DlinkedList
    {
        
        DlinkedNode head;
        DlinkedNode tail;
        
        private DlinkedList()
        {
            head = new DlinkedNode(0,0);
            tail = new DlinkedNode(0,0);
            head. next = tail;
            tail. prev = head;
        }
        
        private void removeToHead(DlinkedNode node)
        {
            DlinkedNode tmp = node;
            node.prev.next = node.next;
            node.next.prev = tmp.prev;
            tmp.next = head.next;
            head.next.prev = tmp;
            tmp.prev = head;
            head.next = tmp;
        }
        
        private void insertAfterHead(DlinkedNode node)
        {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;           
        }
        
        private int deleteBeforeTail()
        {
            DlinkedNode tmp = tail.prev;
            tmp.prev.next = tail;
            tail.prev = tmp.prev;
            return tmp.key;
        }
        
    }
    
    int capacity;
    int size;
    Map<Integer, DlinkedNode> map;
    DlinkedList list;
        
    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<Integer, DlinkedNode>();
        list = new DlinkedList();
    }
    
    public int get(int key) 
    {
        if (!map.containsKey(key)) return -1;
        DlinkedNode node = map.get(key);
        list.removeToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) 
    {
        if(!map.containsKey(key))
        {
            DlinkedNode node = new DlinkedNode(key,value);
            map.put(key,node);
            list.insertAfterHead(node);
            size++;
            
            if (size > capacity) 
            {
                int tmp = list.deleteBeforeTail(); map.remove(tmp);size--;
            }
        }
        else
        {
            DlinkedNode node = map.get(key);
            node.val = value;
            list.removeToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
