// Last updated: 12/14/2025, 1:58:08 PM
1class Solution {
2       public int intersectionSizeTwo(int[][] intervals) {
3        int n = intervals.length;
4        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); 
5        List<Integer> res = new ArrayList<>();
6        res.add(intervals[0][1] - 1); 
7        res.add(intervals[0][1]); 
8        for (int i = 1; i < n; i++) { 
9            int start = intervals[i][0], end = intervals[i][1], size = res.size(), last = res.get(size - 1), secondLast = res.get(size - 2);
10            if (start > last) { 
11                res.add(end - 1);
12                res.add(end);
13            } else if (start == last) res.add(end); 
14            else if (start > secondLast) res.add(end); 
15        }
16        return res.size();
17    }
18}