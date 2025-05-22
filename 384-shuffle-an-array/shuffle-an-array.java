class Solution {
    private int[] orig;
    private int[] copy;
    private Random random =new Random();
    public Solution(int[] nums) {
        orig=nums.clone();
        copy=nums;
    }
    
    public int[] reset() {
        return orig;
    }
    
    public int[] shuffle() {
        int index = random.nextInt(copy.length-1);
        int t=copy[index];
        copy[index]=copy[copy.length-1];
        copy[copy.length-1]=t;
        return copy;
    }
}