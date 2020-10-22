/*
LeetCode Problem No.0763:   https://link.zhihu.com/?target=https%3A//leetcode-cn.com/problems/partition-labels/
Author:                     zhangyixing1007
Idea:                       combine intervals
Time:                       6 ms, beat 42.20%
Space:                      36.9 MB, beat 97.69%
*/

// 基本思路：
// 1. min max 求每一个字母出现位置的最小位置和最大位置
// 2. 合并区间--这个之前有一道题提过的
// 3. 合并完了的区间 应该自动不重不漏 覆盖好整个区间 此时只需要对左端点排序 然后计算即可？
class Solution {
    public List<Integer> partitionLabels(String S) {
        if(S.length()==1) return new ArrayList<Integer>() {{ add(1); }};
        int[] min=new int[26]; Arrays.fill(min, S.length());
        int[] max=new int[26]; Arrays.fill(max, -1);
        for(int i=0; i<S.length(); i++){
            int c=S.charAt(i)-'a';
            min[c]=Math.min(min[c], i);
            max[c]=Math.max(max[c], i);
        }
        int[][] t=new int[26][2]; int j=0;
        for(int i=0; i<26; i++){
            if(max[i]==-1) continue;
            t[j][0]=min[i]; t[j][1]=max[i];
            j++;
        }       
        Arrays.sort(t, 0, j, (o1, o2)->o1[0]==o2[0]? o1[1]-o2[1]:o1[0]-o2[0]);
        int left=t[0][0], right=t[0][1];
        List<Integer> ans=new ArrayList<>();
        for(int i=1; i<j; i++){
            if(right>t[i][0]){
                right=Math.max(right, t[i][1]);

            }else{
                ans.add(right-left+1);
                left=t[i][0]; right=t[i][1];
            }
        }
        ans.add(right-left+1);
        return ans;
    }
}
