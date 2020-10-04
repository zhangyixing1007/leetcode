
/*
LeetCode Problem No.5517:   https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests/
Author:                     zhangyixing1007
Idea:                       PriorityQueue+TreeSet
Time:                       168 ms
Space:                      58 MB
*/

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> avail=new TreeSet<Integer>();
        for(int i=0; i<k; i++) avail.add(i);
        PriorityQueue<Node> pq=new PriorityQueue<>((o1,o2)->o1.time-o2.time);
        int n=arrival.length;
        int[] count=new int[n];
        for(int i=0; i<n; i++){
            while(!pq.isEmpty()&&pq.peek().time<=arrival[i]){
                avail.add(pq.poll().server);
            }
            if(avail.isEmpty()) continue;
            Integer currServer=avail.ceiling(i%k);
            if(currServer==null) currServer=avail.first();
            pq.add(new Node(currServer, arrival[i]+load[i]));
            avail.remove(currServer);
            count[currServer]++;
        }
        int max=0;
        for(int c:count) max=Math.max(max, c);
        List<Integer> ans=new ArrayList<>();
        for(int i=0; i<n; i++) if(max==count[i]) ans.add(i);
        return ans;
    }
    class Node{
        Node(int server, int time){
            this.server=server;
            this.time=time;
        }
        int server, time;
    }
}
