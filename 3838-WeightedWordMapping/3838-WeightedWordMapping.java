// Last updated: 6/13/2026, 1:43:45 PM
1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        StringBuilder sb = new StringBuilder();
4
5        for(String word : words){
6            long sum = 0;
7
8            for(char ch : word.toCharArray()){
9                sum += weights[ch - 'a'];
10            }
11            int rem = (int)(sum % 26);
12            sb.append((char)('z' - rem));
13        }
14        return sb.toString();
15    }
16}