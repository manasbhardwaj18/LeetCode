// Last updated: 4/25/2026, 12:50:05 PM
1class Solution {
2    public int maxDistance(int side, int[][] points, int k) {
3        long[] res = new long[points.length];
4        long lSide = (long) side;
5
6        for(int i=0; i< points.length; i++){
7            long x = points[i][0];            
8            long y = points[i][1];
9            if(x== 0) res[i] = y;
10            else if( y ==lSide){
11                res[i] = lSide + x;
12            }
13            else if(x == lSide){
14                res[i] = lSide * 3 - y;
15            }
16            else res[i] = lSide*4 -x;
17        }
18        Arrays.sort(res);
19        int left = 1;
20        int right = (int) ((lSide*4) / k) + 1;
21
22        while(left + 1 < right){
23            int mid = left + (right - left)/2;
24            if(check(mid, res, lSide, k)){
25                left = mid;
26            }else{
27                right = mid;
28            }
29        }
30        return left;
31    }
32
33    private boolean check(int n, long[] res, long lSide, int k){
34        int m = res.length;
35        int[] idx = new int[k];
36        long peri = lSide*4;
37
38        idx[0] = 0;
39        long curr = res[0];
40        for(int i=1; i<k; i++){
41            int pos = Arrays.binarySearch(res, curr + n);
42            if(pos < 0){
43                pos = -(pos + 1);
44            }
45            if(pos == m) return false;
46            idx[i] = pos;
47            curr = res[pos];
48        }
49        if(res[idx[k-1]] - res[0] <= peri - n) return true;
50
51        for(idx[0] = 1; idx[0] < idx[1]; idx[0]++){
52            for(int j=1; j<k; j++){
53                while(idx[j] < m && res[idx[j]] < res[idx[j-1]] + n){
54                    idx[j]++;
55                }
56                if(idx[j] == m) return false;
57            }
58            if(res[idx[k-1]] - res[idx[0]] <= peri - n) return true;
59        }
60        return false;
61    }
62}