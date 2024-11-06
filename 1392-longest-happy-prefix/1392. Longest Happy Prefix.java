class Solution {
    public String longestPrefix(String s) {
          int n = s.length();
        int i = 0;
        int j = 1;
        int[] arr = new int[n];
        while(j < n){
            if(s.charAt(i)==s.charAt(j)){
                arr[j] = i+1;
                i++;
                j++;
            }
            else{
                if(i==0) j++;
                else i = arr[i-1];
            }
        }

        return s.substring(0,arr[n-1]);
    }
}