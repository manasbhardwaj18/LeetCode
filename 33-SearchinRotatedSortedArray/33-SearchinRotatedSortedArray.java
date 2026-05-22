// Last updated: 5/22/2026, 9:47:34 AM
1class Solution {
2    public int search(int[] nums, int target) {
3        List<Integer> list = new ArrayList<>();
4        for(int a : nums){
5            list.add(a);
6        }
7        return list.indexOf(target);
8    }
9}
10
11
12