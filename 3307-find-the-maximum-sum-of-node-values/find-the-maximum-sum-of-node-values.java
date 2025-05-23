class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }
        
        int[] options1 = new int[n];
        int[] options2 = new int[n];
        
        for (int i = 0; i < n; i++) {
            options1[i] = nums[i];
            options2[i] = nums[i] ^ k;
        }
        
        long bestOdd = options2[0];
        long bestEven = options1[0];
        
        for (int i = 1; i < n; i++) {
            long newOdd = Math.max(bestOdd + options1[i], 
                                   bestEven + options2[i]);
            long newEven = Math.max(bestEven + options1[i], 
                                    bestOdd + options2[i]);
            
            bestOdd = newOdd;
            bestEven = newEven;
        }
        
        return bestEven;
    }
}