// Last updated: 11/20/2025, 9:33:57 AM
class Solution {
       public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); 
        List<Integer> res = new ArrayList<>();
        res.add(intervals[0][1] - 1); 
        res.add(intervals[0][1]); 
        for (int i = 1; i < n; i++) { 
            int start = intervals[i][0], end = intervals[i][1], size = res.size(), last = res.get(size - 1), secondLast = res.get(size - 2);
            if (start > last) { 
                res.add(end - 1);
                res.add(end);
            } else if (start == last) res.add(end); 
            else if (start > secondLast) res.add(end); 
        }
        return res.size();
    }
}