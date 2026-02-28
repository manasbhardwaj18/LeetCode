// Last updated: 2/28/2026, 1:32:34 PM
1class Solution {
2    int mod = 1000000007;
3    public int concatenatedBinary(int n) {
4        long res = 0; int len = 0;
5        for(int i=1; i<=n ; i++){
6            if((i & (i-1)) == 0){
7                len++;
8            }
9            res = ((res << len) + i) % mod;
10        }
11        return (int)res;
12    }
13}