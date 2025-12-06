// Last updated: 12/6/2025, 1:47:42 PM
1class Solution {
2    public int countPartitions(int[] nums, int k) {
3        int a = nums.length, mod = 1_000_000_007, acc = 1;
4        int[] dp = new int[a+1];
5        dp[0] = 1;
6
7        Deque<Integer> minq = new ArrayDeque<>();
8        Deque<Integer> maxq = new ArrayDeque<>();
9
10        for(int i=0,j=0;j<a;j++){
11            while(!maxq.isEmpty() && nums[j] > nums[maxq.peekLast()]){
12                maxq.pollLast();
13            }
14            maxq.addLast(j);
15            while(!minq.isEmpty() && nums[j] < nums[minq.peekLast()]){
16                minq.pollLast();
17            }
18            minq.addLast(j);
19
20            while(nums[maxq.peekFirst()] - nums[minq.peekFirst()] > k){
21                acc=(acc-dp[i++] + mod)%mod;
22                if(minq.peekFirst() < i){
23                    minq.pollFirst();
24                }
25                if(maxq.peekFirst() < i){
26                    maxq.pollFirst();
27                }
28            }
29            dp[j+1]=acc;
30            acc = (acc + dp[j+1]) % mod;
31        }
32        return dp[a];
33    }
34}