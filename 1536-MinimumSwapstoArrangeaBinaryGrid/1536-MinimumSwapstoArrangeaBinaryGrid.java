// Last updated: 3/2/2026, 12:33:02 PM
1class Solution {
2    public int minSwaps(int[][] grid) {
3        int n= grid.length;
4        int[] trail = new int[n];
5
6        for(int i=0; i<n; i++){
7            int cnt = 0;
8            for(int j=n-1; j>= 0; j--){
9                if(grid[i][j] == 0){
10                    cnt++;
11                }else{
12                    break;
13                }
14            }
15            trail[i] = cnt;
16        }
17
18        int swap = 0;
19        for(int i=0; i<n; i++){
20            int req = n-1-i;
21            int j=i;
22
23            while(j<n && trail[j] < req){
24                j++;
25            }
26            if(j == n){
27                return -1;
28            }
29
30            while(j>i){
31                int temp = trail[j];
32                trail[j] = trail[j-1];
33                trail[j-1] = temp;
34                swap++;
35                j--;
36            }
37        }
38        return swap;
39    }
40}