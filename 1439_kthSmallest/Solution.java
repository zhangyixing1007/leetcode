/*
LeetCode Problem No.1439:   https://leetcode-cn.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
Author:                     zhangyixing1007
Idea:                       inner class, PriorityQueue, loop
Time:                       161 ms, beat 45.88%
Space:                      44.8 MB, beat 100%
*/

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        if(mat==null||mat.length==0||mat[0].length==0) return 0;
        PriorityQueue<Item> pq=new PriorityQueue<Item>((o1,o2)->o1.total-o2.total);
        int n=mat.length, m=mat[0].length;
        Set<String> set=new HashSet<>();
        int[] pick=new int[n];
        int total=0;
        for(int i=0; i<n; i++) total+=mat[i][0];
        Item first=new Item(pick, total);
        pq.offer(first);
        set.add(Arrays.toString(first.pick));
        while(!pq.isEmpty()&&k>1){
            Item item=pq.poll();
            for(int i=0; i<n; i++){
                item.pick[i]++;
                if(item.pick[i]<m&&!set.contains(Arrays.toString(item.pick))){
                    int[] t=Arrays.copyOf(item.pick, n);
                    total=item.total-mat[i][item.pick[i]-1]+mat[i][item.pick[i]];
                    pq.add(new Item(t,total));
                    set.add(Arrays.toString(t));
                }
                item.pick[i]--;               
            }
            k--;
        }
        return pq.poll().total;
    }

    class Item{
        int[] pick;
        int total;
        public Item(int[] pick, int total){
            this.pick=pick;
            this.total=total;
        }
    }
}
