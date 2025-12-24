// Last updated: 12/24/2025, 1:58:34 PM
1class Solution {
2    public int minimumBoxes(int[] apple, int[] capacity) {
3        Arrays.sort(capacity);
4        int sum = 0, res = 0;
5        int n = apple.length, m = capacity.length;
6        for(int i=0;i<n;i++){
7            sum += apple[i];
8        }
9        for(int i=m-1;i >=0; i--){
10            sum -= capacity[i];
11            res++;
12            if(sum <= 0){
13                return res;
14            }
15        }
16        return res;
17
18    }
19}