// Last updated: 1/2/2026, 12:35:15 PM
1import java.util.*;
2class Solution {
3    public int repeatedNTimes(int[] nums) {
4        int n = nums.length / 2;
5        Set<Integer> seen  = new HashSet<>();
6        for(int x : nums){
7            if(seen.contains(x)){
8                return x;
9            }
10            seen.add(x);
11        }
12        return -1;
13
14    }
15}