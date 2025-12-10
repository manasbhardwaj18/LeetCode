// Last updated: 12/10/2025, 4:18:42 PM
1class Solution {
2    int mod = 1000000007;
3    public int countPermutations(int[] complexity) {
4        long ans = 1;
5        int n = complexity.length;
6        for(int a=1;a<n;a++){
7            if(complexity[a] <= complexity[0]){
8                return 0;
9            }
10        }
11        for(int z=1;z<n;z++){
12            ans = (ans*z)%mod;
13        }
14        return (int) ans;
15    }
16}