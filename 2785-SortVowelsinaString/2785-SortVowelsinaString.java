// Last updated: 9/11/2025, 1:26:08 PM
class Solution {
    public String sortVowels(String s) {
        int[] freq = new int[128];
        String v = "aeiouAEIOU";
        for(char ch: s.toCharArray()){
            if(v.indexOf(ch)!=-1){
                freq[ch]++;
            }
        }
        int k = 0;
        StringBuilder res = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(v.indexOf(ch)!=-1){
                while(k < 128 && freq[k] == 0) k++;
                res.append((char)k);freq[k]--;
            }
            else res.append(ch);
        }
        return res.toString();
    }
}