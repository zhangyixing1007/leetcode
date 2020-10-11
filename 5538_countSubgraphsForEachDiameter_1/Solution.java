/*
LeetCode Problem No.5538:   https://leetcode-cn.com/problems/count-subtrees-with-max-distance-between-cities/
Author:                     zhangyixing1007
Idea:                       Floyed + bfs + state compress
Time:                       6 ms
Space:                      38.4 MB
*/

class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[][] dist=new int[n][n]; //存储两点之间的距离
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            //之后要求最小值 所以初始化成最大整数
            //其实初始化成任何一个大于等于n的数字都可以
            dist[i][i]=0;//本身到本身显然为0
        }        
        int[] dp=new int[1<<(n)];
        //状态压缩存储 dp[j]表示子树j的最大距离
        //j表示成二进制，从右数第k位为1表示第k个节点在子集中否则不在
        for(int[] edge:edges){
            // 直接相连的两点之间距离显然为1
            dist[edge[0]-1][edge[1]-1]=1;
            dist[edge[1]-1][edge[0]-1]=1;
            // 直接相连的两点可以构成一棵子树 它们的最大距离为1
            dp[(1<<(edge[0]-1)) + (1<<(edge[1]-1))]=1;
        }
        // Floyed算法 求每两点之间的最短距离 请全文背诵
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE){
                        dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        // 把对j的循环放在外面
        // 因为显然如果子树A是子树B的一部分 jA<jB
        // 所以要把数字小的j全部求好了再去求数字大的j
        for(int j=1; j<dp.length; j++){
            // 以下我们从子树 j 扩展到子树 j+(1<<i)
            // 即把节点i加入到子树j中
            // 如果本身j就无法构成一棵子树（如果j表示的节点不能相互连通）
            // 那么也就没有必要继续了 所以continue
            if(dp[j]==0) continue;
            for(int i=0; i<n; i++){
                // 如果节点i已经在子树j中 或者 j+(1<<i)已经被计算过了 就没必要算了
                // 为什么它可能会已经被计算过呢？ 
                // 因为 111=101+10=11+100 添加点的顺序不同 但是能得出同样的一棵子树
                if(((1<<i)&j)!=0 || dp[j+(1<<i)]!=0) continue;
                // 检查 j 子树中是否有和 i 直接相连的点 
                // 这其实是相对于子树（而不是某个节点的）的bfs
                for(int k=0; k<n; k++){
                    if(((1<<k)&j)!=0 && dist[i][k]==1){
                        dp[j+(1<<i)]=dp[j];
                        break;
                    }
                }
                // 如果j 子树中没有和 i 直接相连的点
                // 那么也就无法添加这个节点i了
                if(dp[j+(1<<i)]==0) continue;
                // 把节点i添加进来 就要更新新子树的最大距离 dp[j+(1<<i)]
                // 更新的办法是 对于原子树的每一个节点和新节点求最大距离
                // 因为只产生了这些新距离 做增量计算就好
                for(int kk=0; kk<n; kk++){
                    if(((1<<kk)&j)!=0){
                        dp[j+(1<<i)]=Math.max(dp[j+(1<<i)], dist[i][kk]);
                    }
                }
            }
        }
        // 统计结果 由于下标从1开始 
        // ans[0]其实记录的是最大距离为1的子树有多少棵 统计时要-1
        int[] ans=new int[n-1];
        for(int j=0; j<dp.length; j++){
            if(dp[j]!=0) ans[dp[j]-1]++;
        }
        return ans;
    }
}
