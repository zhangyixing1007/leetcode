/*
LeetCode Problem No.5533:   https://leetcode-cn.com/problems/design-parking-system/
Author:                     zhangyixing1007
Idea:                       memory recursion
Time:                       4 ms
Space:                      37 MB
*/

class Solution {
    public int minimumOneBitOperations(int n) {
        map=new HashMap<>();
        int i=1; map.put(i,1); map.put(0,0);
        while(i<n){
            map.put(i<<1, (map.get(i)<<1)+1);
            i<<=1;
        }
        return dfs(n);
    }
    Map<Integer, Integer> map;
    int dfs(int n){
        if(map.containsKey(n)) return map.get(n);
        int t=n;
        t|=t>>1;
        t|=t>>2;
        t|=t>>4;
        t|=t>>8;
        t|=t>>16;
        t+=1;
        t>>=1;
        int ans=dfs(t)-dfs(n-t);
        map.put(n, ans);
        return ans;
    }
}
