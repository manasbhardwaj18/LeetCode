// Last updated: 5/14/2026, 5:57:06 PM
1class Solution {
2    public boolean isGood(int[] nums) {
3        int n = nums.length - 1;
4        Set<Integer> s1 = new HashSet<>();
5
6        boolean dup = false;
7
8        for(int num : nums){
9            if(num > n) return false;
10
11            if(s1.contains(num)){
12                if(num < n || dup) return false;
13                dup = true;
14                continue;
15            }
16            s1.add(num);
17        }
18        return true;
19    }
20}