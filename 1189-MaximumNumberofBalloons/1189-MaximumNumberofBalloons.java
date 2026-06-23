// Last updated: 6/23/2026, 2:25:12 PM
1class Solution {
2    public int maxNumberOfBalloons(String text) {
3        int count[] = new int[26];
4        for(char c : text.toCharArray()){
5            count[c - 'a']++;
6        }
7
8        return Math.min(
9            Math.min(count['b' - 'a'], count['a' - 'a']),
10            Math.min(count['l'-'a']/2,
11            Math.min(count['o' - 'a']/2, count['n' - 'a']))
12        );
13    }
14}