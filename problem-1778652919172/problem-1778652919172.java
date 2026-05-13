// Last updated: 5/13/2026, 11:45:19 AM
1class Solution {
2    public int minMoves(int[] nums, int limit) {
3        int n = nums.length;
4
5        int[] diff = new int[2*limit + 2];
6
7        for(int i=0; i < n/2; i++){
8            int a = nums[i], b = nums[n - 1 - i];
9
10            int low = Math.min(a,b) + 1;
11            int high = Math.max(a,b) + limit;
12            int sum = a + b;
13
14            diff[2] += 2;
15            diff[2 * limit + 1] -= 2;
16
17            diff[low] -= 1;
18            diff[high + 1] += 1;
19
20            diff[sum] -= 1;
21            diff[sum + 1] += 1;
22        }
23
24        int ans = Integer.MAX_VALUE;
25        int moves = 0;
26
27        for(int target = 2; target <= 2 * limit; target++){
28            moves += diff[target];
29            ans = Math.min(ans, moves);
30        }
31        return ans;
32    }
33}