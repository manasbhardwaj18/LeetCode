// Last updated: 1/31/2026, 8:46:01 PM
1class Solution {
2    public int minimumK(int[] nums) {
3        int[] a1 = nums.clone();
4        long total = 0;
5        for(int x : a1){
6            total += x;
7        }
8        int lf = (int) Math.cbrt(total);
9        if((long) lf*lf*lf < total){
10            lf++;
11        }
12        int rt = (int)Math.sqrt(total) + 1;
13
14        
15        
16        while(lf < rt){
17            int mid = lf + (rt - lf) / 2;
18            if(op(a1, mid) <= (long) mid*mid){
19                rt = mid;
20            }else{
21                lf = mid + 1;
22            }
23        }
24        return lf;
25    }
26   int mmax(int[] nums){
27       int m = 0;
28       for(int x : nums){
29           m = Math.max(m,x);
30       }
31       return m;
32   }
33
34    long op(int[] nums,int k){
35        long ops = 0;
36        for(int x : nums){
37            ops += (x + k -1)/k;
38        }
39        return ops;
40    }
41}
42