// Last updated: 9/23/2025, 6:15:26 PM
import java.util.*;

class Solution {
    public int compareVersion(String version1, String version2) {
        int maxRevision = 0;
        int maxRevision2 = 0;

        for (char ch : version1.toCharArray()) {
            if (ch == '.') {
                maxRevision++;
            }
        }
        for (char ch : version2.toCharArray()) {
            if (ch == '.') {
                maxRevision2++;
            }
        }

        int maxR = Math.max(maxRevision, maxRevision2);

        int[] arr = new int[maxR + 1]; 
        int[] arr2 = new int[maxR + 1];

        Arrays.fill(arr, 0);
        Arrays.fill(arr2, 0);

        int num = 0, index = 0;
        for (int i = 0; i < version1.length(); i++) {
            if (version1.charAt(i) == '.') {
                arr[index++] = num;
                num = 0;
            } else {
                num = (num * 10) + (version1.charAt(i) - '0');
            }
        }
        arr[index] = num; 

        num = 0;
        index = 0;
        for (int i = 0; i < version2.length(); i++) {
            if (version2.charAt(i) == '.') {
                arr2[index++] = num;
                num = 0;
            } else {
                num = (num * 10) + (version2.charAt(i) - '0');
            }
        }
        arr2[index] = num; 

        for (int i = 0; i <= maxR; i++) {
            if (arr[i] > arr2[i]) {
                return 1;
            } else if (arr[i] < arr2[i]) {
                return -1;
            }
        }

        return 0;
    }
}