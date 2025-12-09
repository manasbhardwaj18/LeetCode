// Last updated: 12/9/2025, 2:01:26 PM
1class Solution {
2    public int specialTriplets(int[] nums) {
3    final int MOD = 1_000_000_007;
4    int maxVal = 100000;
5    long ans=0;
6    int [] right = new int[maxVal+1];
7    int [] left = new int [maxVal+1];
8    for(int num : nums){
9        right[num]++;
10    }
11    for(int j=0;j<nums.length;j++){
12        int mid= nums[j];
13        long target =(long) mid*2;
14        right[mid]--;
15        if (target <= maxVal) {
16            ans = (ans + ((long) left[(int) target] * right[(int) target]) % MOD) % MOD;
17        }
18        left[mid]++;
19    }
20    return (int)ans;
21    }
22}
23