// Last updated: 5/1/2026, 2:39:28 PM
1class Solution {
2    public int maxRotateFunction(int[] nums) {
3
4      int sum=0;
5      int f=0;
6      int n=nums.length;
7
8      for(int i=0;i<n;i++)
9      {
10          sum+=nums[i];
11          f+=i*nums[i];
12
13      }  
14
15      int max=f;
16      for(int i=n-1;i>0;i--)
17      {
18          max=Math.max(max,f+sum-(n*nums[i]));
19          f=f+sum-(n*nums[i]);
20
21      }
22
23      return max;
24    }
25}