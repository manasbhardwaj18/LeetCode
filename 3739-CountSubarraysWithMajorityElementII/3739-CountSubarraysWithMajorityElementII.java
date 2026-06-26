// Last updated: 6/26/2026, 2:05:28 PM
1class Solution {
2    public long countMajoritySubarrays(int[] nums, int target) {
3        int n = nums.length;
4        int freq[] = new int[2*n +1];
5
6        freq[n] = 1;
7        int idx = n;
8        long res = 0, pref = 0;
9
10        for(int x : nums){
11            if(x  == target){
12                pref += freq[idx];
13                idx++;
14            }else{
15                idx--;
16                pref -= freq[idx];
17            }
18            freq[idx]++;
19            res += pref;
20        }
21        return res;
22    }
23}