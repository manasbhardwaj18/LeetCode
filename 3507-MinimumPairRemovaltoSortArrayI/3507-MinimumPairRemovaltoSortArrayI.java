// Last updated: 1/22/2026, 2:31:57 PM
1class Solution {
2    boolean isSorted(int[] nums, int n){
3        for(int i=1;i<n;i++){
4            if(nums[i] < nums[i-1]){
5                return false;
6            }
7        }
8        return true;
9    }
10    public int minimumPairRemoval(int[] nums) {
11        int ans = 0, n = nums.length;
12        while(!isSorted(nums,n)){
13            ans += 1;
14            int min = Integer.MAX_VALUE;
15            int pos = -1;
16            for(int i=1;i<n;i++){
17                int sum = nums[i-1] + nums[i];
18                if(sum < min){
19                    min = sum;
20                    pos = i;
21                }
22            }
23            nums[pos-1] = min;
24            for(int i=pos; i<n-1;i++){
25                nums[i] = nums[i+1];
26            }
27            n--;
28        }
29        return ans;
30    }
31}