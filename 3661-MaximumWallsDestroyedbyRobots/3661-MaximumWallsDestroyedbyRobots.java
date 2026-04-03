// Last updated: 4/3/2026, 5:22:00 PM
1class Solution {
2    public int maxWalls(int[] robots, int[] distance, int[] walls) {
3        int n = robots.length;
4
5        int[][] x = new int[n+1][2];
6        for(int i=0; i<n; i++){
7            x[i][0] = robots[i];
8            x[i][1] = distance[i];
9        }
10
11        Arrays.sort(x, 0, n, (a,b)-> a[0]-b[0]);
12        Arrays.sort(walls);
13
14        x[n][0] = (int)1e9;
15        x[n][1] = 0;
16
17        BiFunction<int[], Integer, Integer> lowerBound = (arr, target) ->{
18            int l = 0, r = arr.length;
19            while(l<r){
20                int mid = (l+r)/2;
21                if(arr[mid] < target) l = mid +1;
22                else r = mid;
23            } 
24            return l;
25        };
26        BiFunction<int[], Integer, Integer> upperBound = (arr, target) ->{
27            int l = 0, r = arr.length;
28            while(l<r){
29                int mid = (l+r)/2;
30                if(arr[mid] <= target) l = mid +1;
31                else r = mid;
32            } 
33            return l;
34        };
35        BiFunction<Integer, Integer, Integer> query = (l, r) -> {
36            if(l>r) return 0;
37            int it1 = upperBound.apply(walls, r);
38            int it2 = lowerBound.apply(walls, l);
39            return it1 - it2;
40        };
41
42        int[][] dp = new int[n][2];
43
44        dp[0][0] = query.apply(x[0][0]-x[0][1], x[0][0]);
45        if(n > 1){
46            dp[0][1] =  query.apply(
47                x[0][0],
48                Math.min(x[1][0]- 1, x[0][0] + x[0][1])
49            );
50        }else{
51            dp[0][1] = query.apply(x[0][0], x[0][0]+x[0][1]);
52        }
53
54        for(int i=1; i<n; i++){
55           
56            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]) + 
57                       query.apply(
58                            x[i][0], 
59                            Math.min(x[i+1][0]-1, x[i][0] + x[i][1])
60                            );
61
62            dp[i][0] =  dp[i-1][0] + 
63                        query.apply(
64                                Math.max(x[i][0]- x[i][1],  x[i-1][0]+1),
65                                x[i][0]
66                                );   
67
68            int leftStart = Math.max(x[i][0] - x[i][1], x[i-1][0] + 1);   
69            int leftEnd = x[i][0];
70
71            int overlapStart = leftStart;
72            int overlapEnd = Math.min(x[i-1][0]+x[i-1][1], x[i][0]-1);
73
74            int res = dp[i-1][1]
75                      + query.apply(leftStart, leftEnd)
76                      - query.apply(overlapStart, overlapEnd);                               
77        
78            dp[i][0] = Math.max(dp[i][0], res);
79        }
80        return Math.max(dp[n-1][0], dp[n-1][1]);
81    }
82}