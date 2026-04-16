// Last updated: 4/16/2026, 1:25:02 PM
1class Solution {
2    public List<Integer> solveQueries(int[] nums, int[] queries) {
3        int n = nums.length;
4        Map<Integer, List<Integer>> map = new HashMap<>();
5
6        for(int i=0; i<n; i++){
7            map.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i);
8        }
9
10        List<Integer> ans = new ArrayList<>();
11        for(int q : queries){
12            List<Integer> v = map.get(nums[q]);
13
14            if(v.size() == 1){
15                ans.add(-1);
16                continue;
17            }
18
19            int pos = Collections.binarySearch(v, q);
20            int res = Integer.MAX_VALUE;
21
22            int left = v.get((pos-1+v.size()) % v.size());
23            int d1 = Math.abs(q-left);
24            res = Math.min(res, Math.min(d1, n-d1));
25
26            int right = v.get((pos + 1) % v.size());
27            int d2 = Math.abs(q-right);
28            res = Math.min(res, Math.min(d2, n-d2));
29
30            ans.add(res); 
31        }
32        return ans;
33    }
34}