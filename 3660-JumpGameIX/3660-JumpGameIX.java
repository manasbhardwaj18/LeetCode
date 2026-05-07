// Last updated: 5/7/2026, 9:24:45 AM
1class Solution {
2    public int[] maxValue(int[] nums) {
3        int n = nums.length;
4
5        int[] pre = new int[n];
6        int[] suf = new int[n];
7        int[] res = new int[n];
8
9        pre[0] = nums[0];
10        for(int i=1; i<n; i++){
11            pre[i] = Math.max(pre[i-1],nums[i]);
12        }
13
14        suf[n-1] = nums[n-1];
15        for(int i = n-2; i >= 0; i--){
16            suf[i] = Math.min(suf[i+1], nums[i]);
17        }
18
19        res[n-1] = pre[n-1];
20
21        for(int i=n-2; i>= 0; i--){
22            if(pre[i] > suf[i+1]){
23                res[i] = res[i+1];
24            }else{
25                res[i] = pre[i];
26            }
27        }
28        return res;
29    }
30}