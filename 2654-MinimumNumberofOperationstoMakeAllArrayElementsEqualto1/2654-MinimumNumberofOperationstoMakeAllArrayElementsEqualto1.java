// Last updated: 11/12/2025, 3:25:08 PM
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, ones=0;
        for(int x : nums ){
            if(x==1) {
                ones++;
            }
        }
        if(ones >  0) {
                return n-ones;
            }
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int g=nums[i];
            for(int j=i+1;j<n;j++){
                g = gcd(g,nums[j]);
                if(g==1){
                    minLen = Math.min(minLen, j-i+1);
                    break;
                }
            }
        }
        if(minLen == Integer.MAX_VALUE){
            return -1;
        }
        return (minLen - 1) + (n-1); // total steps
    }

    private int gcd(int a,int b){
        while(b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
