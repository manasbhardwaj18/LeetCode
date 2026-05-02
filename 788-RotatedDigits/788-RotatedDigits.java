// Last updated: 5/3/2026, 3:23:58 AM
1class Solution {
2    public int rotatedDigits(int n) {
3        int count = 0;
4        for(int i = 1; i <= n; i++){
5            int check = i;
6            boolean valid = true;
7            boolean changed = false;
8            while(check > 0 && valid){
9                int digit = check % 10;
10                if(digit == 3 || digit == 4 || digit == 7){
11                    valid = false;
12                }else if(digit == 2 || digit == 5 || digit == 6 || digit == 9){
13                    changed = true;
14                }
15                check /= 10;
16            }
17            if(valid && changed){
18                count++;
19            }
20        }
21        return count;
22    }
23}