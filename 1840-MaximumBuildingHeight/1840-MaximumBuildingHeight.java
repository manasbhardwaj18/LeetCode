// Last updated: 6/20/2026, 5:27:34 PM
1class Solution {
2    public int maxBuilding(int n, int[][] restrictions) {
3        List<int[]> one = new ArrayList<>();
4
5        for(int[] r : restrictions){
6            one.add(new int[]{r[0], r[1]});
7        }
8
9        one.add(new int[]{1,0});
10        one.sort((a,b)->Integer.compare(a[0],b[0]));
11
12        if(one.get(one.size() - 1)[0] != n){
13            one.add(new int[]{n, n-1});
14        }
15        int m = one.size();
16
17        for(int i=1; i<m; i++){
18            int dist = one.get(i)[0] - one.get(i-1)[0];
19            one.get(i)[1] = Math.min(one.get(i)[1], one.get(i-1)[1] + dist);
20        }
21
22        for(int i= m-2; i>= 0; i-- ){
23            int dist = one.get(i+1)[0] - one.get(i)[0];
24            one.get(i)[1] = Math.min(one.get(i)[1], one.get(i+1)[1] + dist);
25        }
26        long res = 0;
27
28        for(int i=1; i<m; i++){
29            long x1 = one.get(i-1)[0];
30            long h1 = one.get(i-1)[1];
31
32            long x2 = one.get(i)[0];
33            long h2 = one.get(i)[1];
34
35            long dis = x2-x1;
36            res = Math.max(res, (h1+h2+dis)/2);
37        }
38        return (int) res;
39    }
40}