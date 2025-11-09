// Last updated: 11/9/2025, 12:24:47 PM
class Solution {
    public int countOperations(int num1, int num2) {
        return (num1 == 0 || num2 == 0) ? 0 : num1 / num2 + countOperations(num2, num1 % num2);
    }
}
