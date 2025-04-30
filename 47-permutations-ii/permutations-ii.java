class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        permu(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    private void permu(List<List<Integer>> ans, List<Integer> subans, int[] nums, boolean[] b) {
        if(subans.size() == nums.length){
            ans.add(new ArrayList<>(subans));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(b[i] || i > 0 && nums[i] == nums[i-1] && !b[i - 1]){
                    continue;
                }
                b[i] = true;
                subans.add(nums[i]);
                permu(ans, subans, nums, b);
                b[i] = false;
                subans.remove(subans.size() - 1);
            }
        }
    }
}