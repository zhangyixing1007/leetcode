/*
LeetCode Problem No.0685:   https://leetcode-cn.com/problems/redundant-connection-ii/
Author:                     zhangyixing1007
Idea:                       unionfind
Time:                       1 ms, beat 98.28%
Space:                      38.6 MB, beat 99.78%
*/

/*
多余的边一共有三种情况
[1] 非根节点指向根节点 有环 无冲突
[2] 上层节点节点指向下层节点 无环 有冲突
[3] 下层节点指向上层节点（上层节点非根） 有环 有冲突
*/

class Solution { 
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodesCount = edges.length;
        UnionFind uf = new UnionFind(nodesCount + 1);
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; ++i) {
            parent[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodesCount; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            // 如果这个节点之前已经有了父亲 产生冲突 情况[2][3]
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                parent[node2] = node1;
                // 检查node1和node2所在的无向子图是否连通 如果连通 
                // 说明这一条边导致了环路的发生 记录该边序号
                // 否则就连接node1和node2所在的无向子图
                // 连的是UnionFind中的ancestor 和之前的parent无关
                if (uf.find(node1) == uf.find(node2)) {
                    //无冲突 产生环 情况[1]
                    cycle = i;
                } else {
                    uf.union(node1, node2);
                }
            }
        }
        // 如果没有冲突，那么一定存在环路
        // 且环路的最后连接边即为所求 情况[1]
        if (conflict < 0) {
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        } else {
            int[] conflictEdge = edges[conflict];
            // conflictEdge是不会连接的
            // 如果这时候都出现了环路 
            // 那么只能是另一个指向conflictEdge[1]出现了问题
            // 否则 已经连接好的这棵树就是一棵符合要求的树
            // 出现冲突的conflictEdge就是多余的那条边
            if (cycle >= 0) {
                // 情况[3]
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else {
                // 情况[2][3]都有可能
                return conflictEdge;
            }
        }
    }
}

class UnionFind {
    int[] ancestor;

    public UnionFind(int n) {
        ancestor = new int[n];
        for (int i = 0; i < n; ++i) {
            ancestor[i] = i;
        }
    }

    public void union(int index1, int index2) {
        ancestor[find(index1)] = find(index2);
    }

    public int find(int index) {
        if (ancestor[index] != index) {
            ancestor[index] = find(ancestor[index]);
        }
        return ancestor[index];
    }
}
