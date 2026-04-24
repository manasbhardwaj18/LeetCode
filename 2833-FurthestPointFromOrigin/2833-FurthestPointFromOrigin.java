// Last updated: 4/24/2026, 12:15:14 PM
1class Solution {
2    public int furthestDistanceFromOrigin(String moves) {
3        int left = 0, right = 0, blank = 0;
4
5        for(int i = 0; i < moves.length(); i++){
6            if(moves.charAt(i) == 'L') left++;
7            else if(moves.charAt(i) == 'R') right++;
8            else blank++;
9        }
10        return Math.abs(left-right) + blank;
11    }
12}