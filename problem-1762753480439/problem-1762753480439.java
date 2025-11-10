// Last updated: 11/10/2025, 11:14:40 AM
class Solution {
    public int minOperations(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        for(int x : nums){
            while(!stack.isEmpty() && stack.peekLast() > x){
                stack.pollLast();
            }
            if(x == 0){
                continue;
            }
            if(stack.isEmpty() || stack.peekLast() < x){
                count++;
                stack.addLast(x);
            }
        }
        return count;
    }
}