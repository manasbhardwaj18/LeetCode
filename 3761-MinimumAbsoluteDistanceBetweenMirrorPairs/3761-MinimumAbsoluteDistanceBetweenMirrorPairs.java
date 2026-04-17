// Last updated: 4/17/2026, 10:59:19 AM
1class Solution {
2    public int minMirrorPairDistance(int[] nums) {
3        int res = 100000, i= 0 ;
4        HashMap<Integer, Integer> view = new HashMap<>();
5
6        for(int n : nums){
7            int r;
8            if(view.containsKey(n)){
9                res = Math.min(res, i-view.get(n));
10            }
11
12            for(r = 0; n>0; n /= 10){
13                r = r*10 + (n%10);
14            }
15            view.put(r, i++);
16        }
17        return res == 100000 ? -1 : res;
18    }
19}