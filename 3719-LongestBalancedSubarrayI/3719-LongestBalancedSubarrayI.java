// Last updated: 2/10/2026, 5:25:35 PM
class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i=0;i<n;i++){
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();
            for(int j=i;j<n;j++){
                if(nums[j]%2==0) even.add(nums[j]);
                else odd.add(nums[j]);
                if(even.size()==odd.size()) max = Math.max(max,j-i+1);
            }
        }
        return max;
    }
}