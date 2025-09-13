// Last updated: 9/13/2025, 12:25:18 PM
class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int maxVowel = 0, maxCons = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char)('a' + i);
            if ("aeiou".indexOf(c) >= 0){
                maxVowel = Math.max(maxVowel, freq[i]);
            }
            else{
                maxCons = Math.max(maxCons, freq[i]);
            }
        }
        return maxVowel + maxCons;
    }
}
