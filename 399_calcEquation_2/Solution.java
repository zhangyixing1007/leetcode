/*
LeetCode Problem No.399:    https://leetcode.com/problems/evaluate-division/
Author:                     zhangyixing1007
Idea:                       dfs, HashMap record a weighted graph
Time:                       1 ms, beat 100%
Space:                      35 MB, beat 65%
*/

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> map=formGraph(equations, values);
        double[] ans=new double[queries.size()];
        for (int i=0; i<queries.size(); i++){
            ans[i]=dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>(), map);
        }
        return ans;
    }
    
    HashMap<String,HashMap<String,Double>> formGraph(List<List<String>> equations, double[] values){
        HashMap<String,HashMap<String,Double>> map=new HashMap<>();
        for (int i=0; i<equations.size(); i++){
            String v0=equations.get(i).get(0);
            String v1=equations.get(i).get(1);
            if(!map.containsKey(v0)) map.put(v0, new HashMap<>());
            if(!map.containsKey(v1)) map.put(v1, new HashMap<>());
            map.get(v0).put(v1, values[i]);
            map.get(v1).put(v0, 1/values[i]);            
        }
        return map;
    }
    
    double dfs(String v0, String v1, HashSet<String> set, HashMap<String, HashMap<String, Double>> map){
        if(!map.containsKey(v0)||!map.containsKey(v1)) return -1.0;
        if(v0.equals(v1)) return 1.0;
        if(map.get(v0).containsKey(v1)) return map.get(v0).get(v1);
        set.add(v0);
        for (String v:map.get(v0).keySet()){
            double v0v=map.get(v0).get(v);
            double vv1=-1.0;
            if(!set.contains(v)) vv1=dfs(v, v1, set, map);
            if(vv1!=-1.0) return v0v*vv1;
        }
        return -1.0;
    }
}
