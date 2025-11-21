// Last updated: 11/21/2025, 12:12:33 PM
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n =s.length();
        int[] first = new int[26];
        Arrays.fill(first,-1);
        for(int i=0;i<n;i++){
            char element = s.charAt(i);
            int idx = element-'a';

            if(first[idx] == -1){
                first[idx] = i;
            }
        }
        int[] last = new int[26];
        Arrays.fill(last,-1);
        for(int i=n-1;i>=0;i--){
            char element = s.charAt(i);
            int index = element-'a';

            if(last[index] == -1){
                last[index] = i;
            }
        }
        int result = 0;

        for(int i=0;i<26;i++){
            int start =first[i];
            int end = last[i];
            int temp=0;
            if(start!=-1 && end!=-1){
                HashSet<Character> set1 = new HashSet<>();
                for(int j=start+1;j<end;j++){
                    char element = s.charAt(j);
                    if(!set1.contains(element)){
                        set1.add(element);
                        temp++;
                    }
                }
                set1.clear();
            }
            result += temp;
        }
        return result;
    }
}