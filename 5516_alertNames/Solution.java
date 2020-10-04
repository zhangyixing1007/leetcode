/*
LeetCode Problem No.5516:   https://leetcode-cn.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
Author:                     zhangyixing1007
Idea:                       HashMap<String, List<Integer>>, sort List
Time:                       73 ms
Space:                      56.8 MB
*/

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map=new HashMap<>();
        Set<String> set=new HashSet<>();
        for(int i=0; i<keyName.length; i++){
            int time=Integer.parseInt((keyTime[i].substring(0,2)))*60+Integer.parseInt(keyTime[i].substring(3,5));
            if(!map.containsKey(keyName[i])) map.put(keyName[i], new ArrayList<Integer>());
            map.get(keyName[i]).add(time);
        }
        for(String name:map.keySet()){
            if(map.get(name).size()<3) continue;
            List<Integer> list=map.get(name);
            Collections.sort(list);
            for(int i=0; i+2<list.size(); i++){
                int diff=list.get(i+2)-list.get(i);
                if(diff<=60) {
                    set.add(name);
                    break;
                }
            }
        }
        List<String> ans=new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}
