// Last updated: 1/21/2026, 1:26:21 PM
1class Solution {
2    public int[] minBitwiseArray(List<Integer> nums) {
3        int n = nums.size();
4        int[] res = new int[n];
5        Arrays.fill(res, -1);
6
7        for(int i =0; i<n; i++){
8            if(nums.get(i) == 2){
9                continue;
10            }
11            int a = nums.get(i);
12            int pos = 0;
13
14            while(a > 0 && ((a >> pos ) & 1 ) == 1 ){
15                pos++;
16            }
17
18            if((1 << pos) > a){
19                int topBit = 31 - Integer.numberOfLeadingZeros(a);
20                a = a & ~(1 << topBit);
21            }else{
22                a = a & ~(1 << (pos - 1));
23            }
24            res[i] = a;
25        }
26        return res;
27    }
28}