// Last updated: 1/31/2026, 3:09:07 PM
1class Solution {
2    public char nextGreatestLetter(char[] letters, char target) {
3        int left = 0;
4        int right = letters.length - 1;
5
6        while (left <= right) {
7            int mid = left + (right - left) / 2;
8
9            if (letters[mid] <= target) {
10                left = mid + 1;
11            } else {
12                right = mid - 1;
13            }
14        }
15
16        return letters[left % letters.length];
17    }
18}