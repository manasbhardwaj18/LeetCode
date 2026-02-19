// Last updated: 2/19/2026, 3:13:30 PM
1class Solution {
2    public int countBinarySubstrings(String s) {
3        int ans= 0, prev = 0, cnt = 1;
4
5        for(int i=1; i<s.length(); i++){
6            if(s.charAt(i) == s.charAt(i-1)){
7                cnt++;
8            }else{
9                prev = cnt;
10                cnt = 1;
11            }
12            if(cnt <= prev){
13                ans++;
14            }
15        }
16        return ans;
17    }
18}