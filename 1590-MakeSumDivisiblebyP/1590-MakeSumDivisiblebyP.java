// Last updated: 11/30/2025, 2:35:22 PM
1class Solution {
2    public int minSubarray(int[] nums, int p) {
3        long sum = 0;
4        for(int i=0;i<nums.length;i++){
5            sum += nums[i];
6        }
7        if(sum % p == 0){
8            return 0;
9        }
10        int requiredRem = (int) (sum%p);
11        HashMap<Integer, Integer> rem = new HashMap<>();
12        rem.put(0,-1);
13        sum=0;
14        int res=nums.length;
15        for(int i=0;i<nums.length;i++){
16            sum+=nums[i];
17            int curRem = (int)(sum%p);
18            int search = curRem - requiredRem;
19            if(search < 0){
20                search +=p;
21            }
22            if(rem.containsKey(search)){
23                res = Math.min(res, i - rem.get(search));
24            }
25            rem.put(curRem,i);
26        } 
27        return (res == nums.length)?-1:res;
28    }
29}