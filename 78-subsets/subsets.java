class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        if(nums==null || nums.length==0) return result;
        
        subsets(nums,new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void subsets(int[] nums, ArrayList<Integer> temp, int index) {
        if(index >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        
        temp.add(nums[index]);
        subsets(nums, temp, index+1); 
        temp.remove(temp.size()-1);
        
        subsets(nums, temp, index+1); 
    }
}