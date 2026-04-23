// Last updated: 4/23/2026, 12:39:48 PM
1class Solution {
2    public long[] distance(int[] nums) {
3        Map<Integer, List<Integer> > map = new HashMap<>();
4        int n = nums.length;
5        for(int i=0; i<n; i++){
6            map.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
7        }
8        long[] res = new long[n];
9        for(List<Integer> v : map.values()){
10            if(v.size() > 1){
11                int c = v.size();
12                int i = v.get(0);
13                long sum = 0;
14                for(int x : v){
15                    sum += x;
16                }
17                res[i] = sum - (long)c * i;
18                int x = 0, y = c-2;
19                for(int k=1; k < c; k++){
20                    int nidx = v.get(k);
21                    res[nidx] = res[i] + (long)(x-y)*(nidx-i);
22                    x++;
23                    y--;
24                    i = nidx;
25                }
26            }
27        }
28        return res;
29    }
30}