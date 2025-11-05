// Last updated: 11/5/2025, 9:51:13 PM
class Solution {

    private final TreeSet<int[]> left = new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
    private final TreeSet<int[]> right = new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
    private final Map<Integer, Integer> count = new HashMap<>();
    private long sum = 0;

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] res = new long[n - k + 1];
        for (int i = 0; i < n; i++) {
            delete(nums[i]);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            insert(nums[i]);

            int l = i + 1 - k;
            if (l < 0) {
                continue;
            }

            while (!right.isEmpty() && left.size() < x) {
                rightToLeft();
            }
            while (left.size() > x) {
                leftToRight();
            }
            res[l] = sum;

            delete(nums[l]);
            count.put(nums[l], count.getOrDefault(nums[l], 0) - 1);
            insert(nums[l]);
        }
        return res;    
    }

    private void insert(int val) {
        int cnt = count.getOrDefault(val, 0);
        if (cnt == 0) {
            return;
        }
        int[] arr = new int[]{cnt, val};
        if (!left.isEmpty() && left.comparator().compare(arr, left.first()) > 0) {
            sum += (long) arr[0] * arr[1];
            left.add(arr);
        } else {
            right.add(arr);
        }
    }

    private void delete(int val) {
        int cnt = count.getOrDefault(val, 0);
        if (cnt == 0) {
            return;
        }
        int[] arr = new int[]{cnt, val};
        if (left.contains(arr)) {
            sum -= (long) arr[0] * arr[1];
            left.remove(arr);
        } else {
            right.remove(arr);
        }
    }

    private void leftToRight() {
        int[] arr = left.pollFirst();
        sum -= (long) arr[0] * arr[1];
        right.add(arr);
    }

    private void rightToLeft() {
        int[] arr = right.pollLast();
        sum += (long) arr[0] * arr[1];
        left.add(arr);
    }
}