// Last updated: 12/4/2025, 1:42:43 PM
1class Solution {
2    public int countCollisions(String directions) {
3        int n = directions.length();
4        int ans=0, left=0, right=n-1;
5        while(left < n && directions.charAt(left) == 'L'){
6            left++;
7        }
8        while(right >= left && directions.charAt(right) == 'R'){
9                        right--;
10        }
11        for(int i=left;i<=right;i++){
12            if(directions.charAt(i) != 'S'){
13                ans++;
14            }
15        }
16        return ans;
17    }
18}