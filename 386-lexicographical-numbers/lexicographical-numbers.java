class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int count = 1;

        for (int i = 0; i < n; i++) {
            result.add(count);
            if (count * 10 <= n) {
                count *= 10;  
            } else {
                if (count >= n) count /= 10;  
                count++;
                while (count % 10 == 0) {
                    count /= 10;  
                }
            }
        }
        return result;
    }
}