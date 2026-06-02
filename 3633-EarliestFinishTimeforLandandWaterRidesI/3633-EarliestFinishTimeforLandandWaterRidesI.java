// Last updated: 6/2/2026, 9:32:16 AM
1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
3        int fin = Integer.MAX_VALUE;
4        
5        for(int i=0; i < landStartTime.length; i++){
6            int time = landStartTime[i] + landDuration[i];
7
8            for(int j=0; j < waterStartTime.length; j++){
9                fin = Math.min(fin, Math.max(time, waterStartTime[j]) + waterDuration[j]);
10            }
11        }
12
13        for(int i=0; i < waterStartTime.length; i++){
14            int time = waterStartTime[i] + waterDuration[i];
15
16            for(int j=0; j < landStartTime.length; j++){
17                fin = Math.min(fin, Math.max(time, landStartTime[j]) + landDuration[j]);
18            }
19        }
20        return fin;
21    }
22}