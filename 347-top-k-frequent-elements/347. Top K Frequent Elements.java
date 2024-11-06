class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         int[] ans =new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.merge(nums[i],1,Integer::sum);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> map.get(b) - map.get(a));
       for(int i=0;i<k;i++){
        ans[i]=list.get(i);
       }
       return ans;
    }
}