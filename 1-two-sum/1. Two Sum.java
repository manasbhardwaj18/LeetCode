class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> index = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length;i++){
            Integer reqNum = (Integer)(target - nums[i]);
            if(index.containsKey(reqNum)){
                int toReturn[] = {index.get(reqNum), i};
                return toReturn;
            }
            index.put(nums[i],i);
        }
        return null; 
    }
}