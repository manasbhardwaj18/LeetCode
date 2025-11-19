// Last updated: 11/19/2025, 11:48:53 AM
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        while (numSet.contains(original)) {
            original *= 2;
        }
        
        return original;
    }
}