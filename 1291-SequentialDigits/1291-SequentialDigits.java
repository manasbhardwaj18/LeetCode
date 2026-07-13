// Last updated: 7/13/2026, 11:38:04 AM
1class Solution {
2    public List<Integer> sequentialDigits(int low, int high) {
3        List<Integer> sol = new ArrayList<>();
4        for(int i=1; i<=9; i++){
5            int num = i;
6            for(int j=i+1; j<=9; j++){
7                num = num*10 + j;
8                if(num >= low && num <= high){
9                    sol.add(num);
10                }
11            }
12        }
13        Collections.sort(sol);
14        return sol;
15    }
16}