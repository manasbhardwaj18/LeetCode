// Last updated: 10/31/2025, 7:02:58 PM
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length-2;
        int[] cnt = new int[n];

        List<Integer> sneak = new ArrayList<>();
        for(int num : nums){
            cnt[num]++;
            if(cnt[num] == 2){
                sneak.add(num);
            }
        }
        return new int[] {sneak.get(0) , sneak.get(1)};
    }
}