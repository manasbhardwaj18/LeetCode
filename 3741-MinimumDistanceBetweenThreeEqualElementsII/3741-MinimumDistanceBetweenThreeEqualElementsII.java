// Last updated: 4/11/2026, 12:32:04 PM
1class Solution {
2    public int minimumDistance(int[] nums) {
3       Map<Integer, int[]> map1 = new HashMap<>();
4       int mini = Integer.MAX_VALUE;
5
6       for(int i=0; i<nums.length; i++){
7            if(!map1.containsKey(nums[i])){
8                map1.put(nums[i], new int[]{-1, i});
9            }else{
10                int[] pair = map1.get(nums[i]);
11                int prev = pair[0];
12                int last = pair[1];
13
14                if(prev != -1){
15                    int a = prev, b = last, c= i;
16                    int diff = 2*(c-a);
17                    mini = Math.min(mini, diff);
18                }
19                pair[0] = last;
20                pair[1] = i;
21            }
22        }
23        return mini == Integer.MAX_VALUE ? -1 : mini;
24
25    }
26}