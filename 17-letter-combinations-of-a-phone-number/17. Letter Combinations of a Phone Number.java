class Solution {
     public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return ans;
        String[] mapping = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        f(digits, "", ans, mapping, 0);
        return ans;
    }

    private List<String> f(String digits, String current, List<String> ans, String[] mapping, int index) {
        if (index == digits.length()) {
            ans.add(current);
            return ans;
        }
        String letters = mapping[digits.charAt(index) - '0']; // this will convert string value to int , so in first go "2" will be converted in 2 , and for 2 it will return abc
        for (int i = 0; i < letters.length(); i++) {
            f(digits, current + letters.charAt(i), ans, mapping, index + 1);
        }
        return ans;
    }
}
   