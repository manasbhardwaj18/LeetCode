// Last updated: 4/28/2026, 1:48:34 PM
1class Solution {
2    public int minOperations(int[][] grid, int x) {
3        int n = grid.length, m = grid[0].length;
4        int[] freq = new int[10001];
5        
6        boolean foundFalse = false;
7        int currChoice = grid[0][0];
8        for (int[] row : grid) {
9            for (int y : row) {
10                freq[y]++;
11                if (Math.abs(currChoice - y) % x != 0)
12                    foundFalse = true;
13            }
14        }
15        if (foundFalse) return -1;
16        int[] arr = new int[n * m];
17        int k = 0;
18        for (int i = 0; i < 10001; i++) {
19            for (int j = 0; j < freq[i]; j++) {
20                arr[k++] = i;
21            }
22        }
23        int count = 0;
24        int median = arr[arr.length / 2];
25        for (int num : arr) {
26            count += Math.abs(num - median) / x;
27        }
28        return count;
29    }
30}