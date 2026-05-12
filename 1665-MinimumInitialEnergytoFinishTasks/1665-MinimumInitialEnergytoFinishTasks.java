// Last updated: 5/12/2026, 9:59:29 AM
1class Solution {
2    public int minimumEffort(int[][] shop) {
3        Arrays.sort(shop, (a,b) -> b[1] - b[0] - (a[1] - a[0]));
4
5        int start = shop[0][1];
6        int bal = shop[0][1] - shop[0][0];
7        int loan  = 0;
8
9        for(int i = 1; i < shop.length; i++){
10            int cost = shop[i][0];
11            int threshold = shop[i][1];
12
13            if(bal < threshold){
14                loan += threshold - bal;
15                bal = threshold;
16            }
17            bal -= cost;
18        }
19        return start + loan;
20    }
21}