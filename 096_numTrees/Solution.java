/*
LeetCode Problem No.96:     https://leetcode.com/problems/unique-binary-search-trees/
Author:                     zhangyixing1007
Idea:                       recursion is very good, to save time, use array as intermediate saving
Time:                       0 ms, beat 100%
Space:                      32.8 MB, beat 10.46%
*/

class Solution {
    public int numTrees(int n) {
        if (n <= 1) return 1;
        // else if (n == 1) return 1;
        else if (n == 2) return 2;
        int[] count = new int[n+1];
        count[0] = 1; count[1] = 1; count[2] = 2;
        for (int i = 3; i < count.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                count[i] += count[j] * count[i-j-1];
            }
        }
        return count[n];
    }
}
