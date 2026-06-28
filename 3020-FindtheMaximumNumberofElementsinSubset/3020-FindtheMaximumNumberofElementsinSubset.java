// Last updated: 6/29/2026, 1:24:05 AM
1class Solution {
2    private static final int MAX_BASE = 31622;
3
4    public int maximumLength(int[] nums) {
5        Map<Integer, Integer> freq = new HashMap<>();
6        for (int n : nums)
7            freq.merge(n, 1, Integer::sum);
8
9        int one = freq.getOrDefault(1, 0);
10        int res = (one - 1) | 1;
11        freq.remove(1);
12
13        for (int f : freq.keySet()) {
14            int sq = (int) Math.sqrt(f);
15            if (sq * sq == f && freq.getOrDefault(sq, 0) > 1)
16                continue;
17
18            int n = 0, x = f;
19
20            while (x < 31623 && freq.containsKey(x) && freq.get(x) > 1) {
21                n += 2;
22                x *= x;
23            }
24
25            res = Math.max(res, n + (freq.containsKey(x) ? 1 : -1));
26        }
27
28        return res;
29    }
30}