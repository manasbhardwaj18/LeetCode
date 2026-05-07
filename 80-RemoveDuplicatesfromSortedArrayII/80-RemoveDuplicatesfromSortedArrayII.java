// Last updated: 5/7/2026, 10:06:47 AM
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        Map<Integer, Integer> count = new HashMap<>();
4        int k=0;
5        for(int num : nums){
6            count.put(num, count.getOrDefault(num, 0) + 1);
7            if(count.get(num) <= 2){
8                nums[k] = num;
9                k++;
10            }
11        }
12        return k;
13    }
14}