// Last updated: 11/3/2025, 7:26:40 PM
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int  left = 0, right;
        final int n = colors.length();
        int removes=0, locMax = 0;
        for(right = 0; right < n; ){
            while(right < n && colors.charAt(right) == colors.charAt(left)){
                removes += neededTime[right];
                locMax = Math.max(locMax, neededTime[right]);
                right++;
            }
            removes -= locMax;
            locMax = 0;
            left = right;
        }
        return removes;
    }
}