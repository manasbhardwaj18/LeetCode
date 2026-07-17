// Last updated: 7/17/2026, 4:39:03 PM
1class Solution {
2    public int[] gcdValues(int[] A, long[] queries) {
3        int max = Arrays.stream(A).max().getAsInt();
4
5        int[] freq = new int[max + 1];
6        long[] GCD = new long[max + 1];
7
8        for (int a : A) freq[a]++;
9
10        for (int i = max; i > 0; i--) {
11            long sum = 0, extra = 0;
12            for (int j = i; j <= max; j += i) {
13                sum += freq[j];
14                extra += GCD[j];
15            }
16            GCD[i] = sum * (sum - 1) / 2 - extra;
17        }
18
19        Arrays.parallelPrefix(GCD, Long::sum);
20        int n = queries.length;
21
22        int[] res = new int[n];
23        for (int i = 0; i < n; i++) {
24            long q = queries[i];
25            int l = 0, h = max + 1;
26            while (l < h) {
27                int m = (l + h) >>> 1;
28                if (GCD[m] <= q) l = m + 1;
29                else h = m;
30            }
31            res[i] = l;
32        }
33
34        return res;
35    }
36}