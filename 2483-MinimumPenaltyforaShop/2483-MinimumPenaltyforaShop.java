// Last updated: 12/26/2025, 2:35:43 PM
1class Solution {
2    public int bestClosingTime(String customers) {
3        int pen = 0, best_case = 0, ans = 0;
4        char[] ch = customers.toCharArray();
5        for(int m=0;m<customers.length();m++){
6            if(ch[m] == 'Y'){
7                pen--;
8                if(pen < best_case){
9                    best_case  = pen;
10                    ans = m+1;
11                }
12            }
13            else{
14                pen++;
15            }
16        }
17        return ans;
18    }
19}