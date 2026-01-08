// Last updated: 1/8/2026, 5:10:52 PM
1class Solution {
2    public int maxDotProduct(int[] nums1, int[] nums2) {
3        int n1 = nums1.length, n2 = nums2.length;
4
5        int[][] dp = new int[n1+1][n2+1];
6        for(int i=0; i<= n1; i++){
7            Arrays.fill(dp[i], Integer.MIN_VALUE/2);
8        }
9        for(int i=1; i<=n1 ; i++){
10            for(int j=1; j<=n2; j++){
11                int pdt = nums1[i-1]*nums2[j-1];
12                int mx = pdt;
13                int cdt = pdt + dp[i-1][j-1];
14                if(cdt > mx){
15                    mx = cdt;
16                }
17                if(dp[i-1][j] > mx){
18                    mx = dp[i-1][j];
19                }
20                if(dp[i][j-1] > mx){
21                    mx = dp[i][j-1];
22                }
23                dp[i][j] = mx;
24            }
25        }
26        return dp[n1][n2];
27    }
28}