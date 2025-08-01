class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int n = 1;n<=numRows;n++){
            List<Integer> a = new ArrayList<>();
            a.add(1);
            int value = 1;
            for(int c = 1;c<n;c++){
                value = value * (n - c);
                value /= c;
                a.add(value);
            }
            ans.add(a);
        }

        return ans;
        
    }
}

