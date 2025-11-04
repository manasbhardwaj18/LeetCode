// Last updated: 11/4/2025, 11:41:08 AM
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        int [] res = new int [nums.length - k + 1];

        for (int i = 0, j = 0, r = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if (j >= k - 1) {
                Queue<int []> q = new PriorityQueue<>((a,b) -> b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);
                for (int key : map.keySet()) {
                    q.add(new int [] {key, map.get(key)});
                }

                int m = x, sum = 0;

                while (!q.isEmpty() && m-- > 0) {
                    int [] a = q.remove();
                    sum += a[0] * a[1];
                }

                res[r++] = sum;
                map.put(nums[i], map.get(nums[i++]) - 1);
            }
        }

        return res;
    }
}