// Last updated: 9/5/2025, 12:48:55 PM
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        int[] interval = new int[1001];  

        for (int j = 0; j < arr.length; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int left = Math.max(0, Math.max(arr[j] - a, arr[k] - c));
                    int right = Math.min(1000, Math.min(arr[j] + a, arr[k] + c));
                    if (left <= right) {
                        if (left == 0)
                            res += interval[right];
                        else
                            res += interval[right] - interval[left - 1];
                    }
                }
            }
            for (int ind = arr[j]; ind <= 1000; ind++) {
                interval[ind]++;
            }
        }

        return res;
    }
}