/*
LeetCode Problem itv64：    https://leetcode-cn.com/problems/qiu-12n-lcof/
Author:                     zhangyixing1007
Idea:                       &&, >>, <<
Time:                       0 ms, beat 100%
Space:                      36.7 MB, beat 100%
*/

class Solution {
    public int sumNums(int n) {
        boolean flag=false;
        int ans=0;
        int A=n, B=n+1;
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;
        
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;    
        
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;
        
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;
        
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;    
        
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;
        
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;
        
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;    
        
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;
        
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;
        
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;    
        
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;
        
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;
        
        flag=((B&1)>0)&&(ans+=A)>0;
        A<<=1; B>>=1;    
       
        return ans>>1;
    }
}
