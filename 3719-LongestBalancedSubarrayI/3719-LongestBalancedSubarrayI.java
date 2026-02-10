// Last updated: 2/10/2026, 5:19:23 PM
1class Solution {
2    public int longestBalanced(int[] nums) {
3        int n = nums.length;
4
5        int[] bal = new int[n];
6        HashMap<Integer, Integer> f1 = new HashMap<>();
7
8        int res= 0;
9        for(int l = n-1; l>=0;l--){
10            int x = nums[l];
11        
12
13            Integer old = f1.get(x);
14            if(old != null){
15                bal[old] = 0;
16            }
17
18            f1.put(x,l);
19            bal[l] = ((x & 1) == 0) ? 1 : -1;
20
21            int s = 0;
22            for(int r = l; r<n;r++){
23                s+= bal[r];
24                if(s==0){
25                    res = Math.max(res, r-l+1);
26                }
27            }
28        }    
29        return res;
30    }
31}