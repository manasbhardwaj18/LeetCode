// Last updated: 3/13/2026, 3:24:09 PM
1class Solution {
2    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
3        long low = 1, high = 10000000000000000L;
4
5        while(low < high){
6            long mid = (low + high) >> 1;
7            long total = 0;
8            for(int i=0; i<workerTimes.length && total < mountainHeight; i++){
9                total += (long) (Math.sqrt((double) mid / workerTimes[i]*2 + 0.25) - 0.5);
10            }
11            if(total >= mountainHeight){
12                high = mid;
13            }else{
14                low = mid + 1;
15            }
16        }
17        return low;
18    }
19}