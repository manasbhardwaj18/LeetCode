class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            int max = i;
            while (!stack.isEmpty() && stack.peek() > i) {
                max = Math.max(max, stack.pop());
            }
            stack.push(max);
        }
        return stack.size();
    }
}