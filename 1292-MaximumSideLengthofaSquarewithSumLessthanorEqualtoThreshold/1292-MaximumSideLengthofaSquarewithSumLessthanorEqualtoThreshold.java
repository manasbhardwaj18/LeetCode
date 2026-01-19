// Last updated: 1/19/2026, 12:27:32 PM
1class Solution {
2
3    boolean isValid(int[][] pre, int k, int limit){
4        int n = pre.length;
5        int m = pre[0].length;
6
7        for(int i=k-1; i<n; i++){
8            for(int j=k-1; j<m; j++){
9                int x1 = i-k + 1;
10                int y1 = j-k + 1;
11
12                int sum = pre[i][j];
13                if(x1 > 0){
14                    sum -= pre[x1-1][j];
15                }
16                if(y1 > 0){
17                    sum -= pre[i][y1 - 1];
18                }
19                if(x1 > 0 && y1 > 0){
20                    sum += pre[x1 -1][y1-1];
21                }
22
23                if(sum <= limit){
24                    return true;
25                }
26            }
27        }
28        return false;
29    }
30
31
32    public int maxSideLength(int[][] mat, int threshold) {
33        int n = mat.length;
34        int m = mat[0].length;
35        int[][] pre = new int[n][m];
36
37        for(int i=0;i<n;i++){
38            System.arraycopy(mat[i],0,pre[i],0,m);
39        }
40
41        for(int i=0;i<n;i++){
42            for(int j=1;j<m;j++){
43                pre[i][j] += pre[i][j-1];
44            }
45        }
46
47        for(int j=0; j<m; j++){
48            for(int i=1;i<n;i++){
49                pre[i][j] += pre[i-1][j];
50            }
51        }
52        int low = 1, high = Math.min(n,m);
53        int ans = 0;
54
55        while(low <= high){
56            int mid = (low + high) / 2;
57            if(isValid(pre,mid,threshold)){
58                ans = mid;
59                low = mid+1;
60            }else{
61                high = mid -1;
62            }
63        }
64        return ans;
65    }
66}