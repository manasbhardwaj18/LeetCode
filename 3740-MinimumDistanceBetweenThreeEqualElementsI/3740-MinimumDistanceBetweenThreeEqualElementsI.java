// Last updated: 4/10/2026, 7:28:55 AM
1class Solution {
2    public int minimumDistance(int[] nums) {
3        int n = nums.length;
4        if(n<=2) return -1;
5        int ans = Integer.MAX_VALUE;
6        for(int i=0; i<n; i++){
7            for(int j=i+1; j<n; j++){
8                if(nums[i]==nums[j]){
9                    for(int k= j+1; k<n; k++){
10                        if(nums[i] == nums[k]){
11                            ans = Math.min(ans,2*(k-i));
12                        }
13                    }
14                }
15            }
16        }
17        return ans == Integer.MAX_VALUE ? -1 : ans;
18    }
19}