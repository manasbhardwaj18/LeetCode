class Solution {
    public String longestWord(String[] arr) {
        Arrays.sort(arr);
        HashSet<String> hp = new HashSet<>();

        String ans = "";
        for(int i=0; i<arr.length; i++){
            String s = arr[i];
            if(s.length()==1 || hp.contains(s.substring(0,s.length()-1))){
                if(s.length()>ans.length()){
                    ans = s;
                }
                hp.add(s);
            }
        }
        return ans;
    }
}