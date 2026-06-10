// Last updated: 6/11/2026, 12:22:07 AM
1class Solution {
2    public long maxTotalValue(int[] nums, int k) {
3        int n = nums.length;
4        SparseTable LUT = new SparseTable(nums);
5
6        PriorityQueue<int[]> pq = new PriorityQueue<>((num, b) -> b[0] - num[0]);
7        for (int i = 0; i < n; i++)
8            pq.add(new int[] { LUT.query(i, n), i, n });
9
10        long res = 0;
11        
12        while (pq.peek()[0] > 0) {
13            int[] top = pq.poll();
14            res += top[0];
15            top[2]--;
16            top[0] = LUT.query(top[1], top[2]);
17            pq.add(top);
18            if (--k <= 0) break;
19        }
20
21        return res;
22    }
23}
24
25class SparseTable {
26    private final int[][] Min, Max;
27
28    public SparseTable(int[] num) {
29        int n = num.length;
30        int bitWidth = 32 - Integer.numberOfLeadingZeros(n);
31        Min = new int[bitWidth][n];
32        Max = new int[bitWidth][n];
33
34        for (int i = 0; i < n; i++)
35            Min[0][i] = Max[0][i] = num[i];
36
37        for (int i = 1; i < bitWidth; i++)
38            for (int j = 0; j + (1 << i) <= n; j++) {
39                Min[i][j] = Math.min(Min[i - 1][j], Min[i - 1][j + (1 << (i - 1))]);
40                Max[i][j] = Math.max(Max[i - 1][j], Max[i - 1][j + (1 << (i - 1))]);
41            }
42    }
43
44    public int query(int left, int right) {
45        int k = 31 - Integer.numberOfLeadingZeros(right - left);
46        return Math.max(Max[k][left], Max[k][right - (1 << k)]) -
47               Math.min(Min[k][left], Min[k][right - (1 << k)]);
48    }
49}