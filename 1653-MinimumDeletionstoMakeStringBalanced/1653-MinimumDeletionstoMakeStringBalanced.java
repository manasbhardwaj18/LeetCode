// Last updated: 2/7/2026, 12:26:20 PM
1class Solution {
2    public int minimumDeletions(String s) {
3        int ans = 0, bCnt = 0;
4        for(int i=0;i < s.length(); i++){
5            char c = s.charAt(i);
6
7            if(c == 'b'){
8                bCnt++;
9            }else if(bCnt > 0){
10                ans++;
11                bCnt--;
12            }
13        }
14        return ans;
15    }
16}