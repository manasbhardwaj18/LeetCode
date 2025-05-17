class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--; // Adjust to 0-based index
            char ch = (char) ('A' + (columnNumber % 26));
            result.insert(0, ch); // Prepend character
            columnNumber /= 26;
        }
        
        return result.toString();
    }
}