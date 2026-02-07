// Last updated: 2/7/2026, 12:29:52 PM
1class Solution {
2    public int minimumDeletions(String s) {
3        int ans = 0, bCnt = 0;
4        for(char c : s.toCharArray()){
5            if(c == 'b'){
6                bCnt++;
7            }else{
8                ans = Math.min(ans+1, bCnt);
9            }
10        }
11        return ans;
12    }
13}
14
15
16
17