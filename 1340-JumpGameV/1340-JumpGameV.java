// Last updated: 5/24/2026, 12:27:34 PM
1class Solution {
2    int[] dp;
3
4    public int maxJumps(int[] arr, int d) {
5        int n = arr.length;
6        dp = new int[n];
7
8        int ans = 1;
9
10        for(int i=0; i < n; i++){
11            ans = Math.max(ans, dfs(i,arr,d));
12        }
13        return ans;
14    }
15
16    int dfs(int i, int[] arr, int d){
17        if(dp[i] != 0){
18            return dp[i];
19        }
20        int best = 1;
21
22        for(int next = i+1; next <= Math.min(arr.length - 1, i+d); next++){
23            if(arr[next] >= arr[i]){
24                break;
25            }
26            best = Math.max(best, 1+dfs(next, arr, d));
27        }
28
29        for(int next = i-1; next >= Math.max(0, i-d); next--){
30            if(arr[next] >= arr[i]){
31                break;
32            }
33            best = Math.max(best, 1+dfs(next, arr, d));
34        }
35        return dp[i] = best;
36    }
37}