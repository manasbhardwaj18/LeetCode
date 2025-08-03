class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> last = new HashMap<>();
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (last.containsKey(num) && last.get(num) >= 3 * res) {
                res = (last.get(num) + 1 + 2) / 3; 
            }
            last.put(num, i);
        }

        return res;
    }
}