/*
LeetCode Problem No.399:    https://leetcode.com/problems/evaluate-division/
Author:                     zhangyixing1007
Idea:                       dfs, HashMap record a weighted graph
Time:                       1 ms, beat 100%
Space:                      35 MB, beat 65%
*/

class Solution{
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>>  graph =
                buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            double tem = queryRes(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
            res[i] = tem;
        }
        return res;
    }


    private HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>>  graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            if(graph.get(equations.get(i).get(0)) == null) {
                graph.put(equations.get(i).get(0), new HashMap<String, Double>());
            }
            graph.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
            if(graph.get(equations.get(i).get(1)) == null) {
                graph.put(equations.get(i).get(1), new HashMap<String, Double>());
            }
            graph.get(equations.get(i).get(1)).put(equations.get(i).get(0),1/ values[i]);
        }
        return graph;
    }


    private double queryRes(HashMap<String, HashMap<String, Double>> graph, String start, String end, HashSet<String> visited) {
        if(!graph.containsKey(start)) return -1.0;
        if(graph.get(start).containsKey(end)) return graph.get(start).get(end);
        visited.add(start);
        for(Map.Entry<String, Double> item : graph.get(start).entrySet()) {
            if(!visited.contains(item.getKey())) {
                double ttt = queryRes(graph, item.getKey(), end, visited);
                if(ttt != -1.0) return ttt*item.getValue();
            }
        }
        return -1.0;
    }
}
