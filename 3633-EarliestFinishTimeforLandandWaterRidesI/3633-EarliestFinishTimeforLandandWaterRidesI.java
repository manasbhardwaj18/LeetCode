// Last updated: 6/2/2026, 9:34:20 AM
1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime,
3        int[] waterDuration) {
4            int n = landStartTime.length;
5            int m = waterStartTime.length;
6        
7            int res = Integer.MAX_VALUE;
8            for (int i = 0; i < n; i++) {
9                for (int j = 0; j < m; j++) {
10                    int land = landStartTime[i] + landDuration[i];
11                    int land_water = Math.max(land, waterStartTime[j]) + waterDuration[j];
12                    res = Math.min(res, land_water);
13
14                    int water = waterStartTime[j] + waterDuration[j];
15                    int water_land = Math.max(water, landStartTime[i]) + landDuration[i];
16                    res = Math.min(res, water_land);
17                }
18            }
19        return res;
20    }
21}