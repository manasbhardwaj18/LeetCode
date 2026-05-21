// Last updated: 5/21/2026, 12:46:47 PM
1class Solution {
2    public int digits(int x){
3        int count = 0;
4        while(x > 0){
5            count++;
6            x /= 10;
7        }
8        return count;
9    }
10
11    public int longestCommonPrefix(int[] arr1, int[] arr2) {
12      HashSet<Integer> prefix = new HashSet<>();
13
14      for(int num : arr1){
15        int x  = num;
16        while(x > 0){
17            prefix.add(x);
18            x /= 10;
19        }
20      }
21
22      int ans = 0;
23
24      for(int num : arr2){
25        int x  = num;
26        int len = digits(num);
27
28        while(x > 0){
29            if(prefix.contains(x)){
30                ans = Math.max(ans, len);
31                break;
32            }
33            x /= 10;
34            len--;
35        } 
36      }
37      return ans;
38    }
39}