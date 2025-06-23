class Solution {
     static int req;
    static long ans;

    static public long kMirror(int k, int n) {
        ans = 0;
        req = n;
        int[] numArr = new int[1000000];
        int[] sizeArr = new int[1000000];
        numArr[0] = 1;
        sizeArr[0] = 1;
        int idx = 1;
        while (req > 0) {
            int num = numArr[--idx], size = sizeArr[idx];

            int[] arr = new int[size];
            int temp = num;
            int len = 0;
            while(temp > 0){
                len++;
                temp /= 10;
            }
            temp = num;
            int i = len - 1, kIdx = i, j = size - 1;
            boolean isAllNine = true;

            while (i >= 0) {
                arr[i] = temp % 10;
                if (arr[i] != 9)
                    isAllNine = false;
                temp /= 10;
                i--;
            }
            i = 0;
            while (j > kIdx) {
                arr[j--] = arr[i++];
            }

            long number = getLong(arr);
            if (isBaseKPalindrome(number, k)) {
                ans += number;
                req--;
                if (req == 0) break;
            }

            if (isAllNine) {
                int nextSize = size + 1;
                int nextNum = (size % 2 == 1) ? ((num + 1) / 10) : (num + 1);
                numArr[idx] = nextNum;
                sizeArr[idx] = nextSize;
            } else {
                numArr[idx] = num + 1;
                sizeArr[idx] = size ;
            }
            idx++;
        }

        return ans;
    }

    private static boolean isBaseKPalindrome(long num, int k) {
        long[] buf = new long[64];
        int idx = 0;
        while (num > 0) {
            buf[idx++] = num % k;
            num /= k;
        }
        return isPalindrome(buf, idx);
    }

    private static boolean isPalindrome(long[] array, int len) {
        int i = 0, j = len - 1;
        while (i < j) {
            if (array[i] != array[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    private static long getLong(int[] arr) {
        long num = 0;
        for (int d : arr) {
            num = num * 10l + (long) d;
        }
        return num;
    }
}