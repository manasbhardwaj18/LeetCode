// Last updated: 11/23/2025, 11:39:37 AM
class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int INF = (int)1e9;
        int rem1_min1 = INF, rem1_min2 = INF;
        int rem2_min1 = INF , rem2_min2 = INF;

        for(int x : nums ){
            sum+=x;
            int r = x % 3;
            if(r==1){
                if(x < rem1_min1){
                    rem1_min2 = rem1_min1;
                    rem1_min1 = x;
                }else if(x < rem1_min2){
                        rem1_min2 = x;
                    }
                }else if(r==2){
                    if(x<rem2_min1){
                        rem2_min2 = rem2_min1;
                        rem2_min1 = x;
                    }else if(x < rem2_min2){
                        rem2_min2 = x;
                    }
                }
            }
        
            int mod = sum % 3;
            if (mod == 0) return sum;
            long removeCost = (long)1e18;
            if(mod == 1){
                if(rem1_min1 != INF) removeCost = Math.min(removeCost,(long)rem1_min1);
                if(rem2_min2 != INF) removeCost = Math.min(removeCost,(long)rem2_min1+rem2_min2);
            }else{
                if(rem2_min1 != INF) removeCost = Math.min(removeCost,(long)rem2_min1);
                if(rem1_min2 != INF) removeCost = Math.min(removeCost,(long)rem1_min1+rem1_min2);
            }
        
        if (removeCost >= (long)1e18) return 0 ;
        return (int)(sum - removeCost);
    }
}