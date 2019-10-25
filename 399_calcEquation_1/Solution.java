/*
LeetCode Problem No.399:    https://leetcode.com/problems/evaluate-division/
Author:                     zhangyixing1007
Idea:                       union find
Time:                       1 ms, beat 100%
Space:                      34.6 MB, beat 82.5%
*/

class Solution {
    Map<String,String> parents = new HashMap<>();
    Map<String,Double> valuess = new HashMap<>(); 
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        for (int i = 0; i < equations.size(); i++){
        union(equations.get(i).get(0),equations.get(i).get(1),values[i]);          
        }
        
        double[] ans = new double[queries.size()];
        for (int i = 0; i < ans.length; i++){
            String str1 = queries.get(i).get(0);
            String str2 = queries.get(i).get(1);
            if (!parents.containsKey(str1)||!parents.containsKey(str2)){
                ans[i] = -1;
            } else if (!find(str1).equals(find(str2))){
                ans[i] = -1;
            } else {
                // ans[i] = valuess.get(str2)/valuess.get(str1);
                ans[i] = cal(str2)/cal(str1);
            }
            
        }
        return ans;     
    }
             
  
    void add(String x){
        if (!parents.containsKey(x)){
            parents.put(x,x);
            valuess.put(x,1.0);
        }
    }        
             
    String find(String child){
        while (!parents.get(child).equals(child)){
            child = parents.get(child);
        }
        return child;
    }
             
    void union(String parent, String child, double value){
        add(parent);
        add(child);
        String p1 = find(parent);
        String p2 = find(child);
        if (!p1.equals(p2)){
            parents.put(p2,parents.get(p1));
            valuess.put(p2,value*valuess.get(parent)/valuess.get(child));
        }
    }
    
    double cal (String child){
        double ans = valuess.get(child);
        while(parents.get(child)!=child){
            child = parents.get(child);
            ans *= valuess.get(child);
        }
        return ans;
    }    
}
