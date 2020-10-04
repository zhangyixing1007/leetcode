/*
LeetCode Problem No.1610:   https://leetcode-cn.com/problems/maximum-number-of-visible-points/
Author:                     zhangyixing1007
Idea:                       atan2, sort angles, two indices
Time:                       174 ms
Space:                      99.8 MB
*/

class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles=new ArrayList<>(points.size());
        int count=0;
        for(int i=0; i<points.size(); i++){
            if(points.get(i).get(0)==location.get(0) && points.get(i).get(1)==location.get(1)){
                count++; continue;
            }
            double theta=Math.toDegrees(
                Math.atan2(points.get(i).get(1)-location.get(1), points.get(i).get(0)-location.get(0)));
            angles.add(theta);
        }
        Collections.sort(angles);
        int L=0, R=0;
        int ans=1;
        for(; L<angles.size(); R=(R+1)%angles.size()){
            while((angles.get(R)-angles.get(L)+360)%360>angle){
                L++;
                if(L==angles.size()||L==R) break;
            }
            if(L<=R) ans=Math.max(ans, R-L+1);
            else ans=Math.max(ans, angles.size()-L+R+1);
            if(ans==angles.size()) break;
        }
        return count+ans;
    }
}
