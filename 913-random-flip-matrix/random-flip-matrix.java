class Solution {
    private int m;
    private int n;
    private HashSet<String> mat;

    public Solution(int m, int n) {
        mat = new HashSet<>();
        this.m = m;
        this.n = n;
    }
    
    public int[] flip() {
        int r = (int) (Math.random() * m);
        int c = (int) (Math.random() * n);
        
        while(mat.contains(r + " " + c)){
            r = (int) (Math.random() * m);
            c = (int) (Math.random() * n);
        }
            
        int output[] = {r, c};
        mat.add(r + " " + c);
                               
        return output;
    }
    
    public void reset() {
        mat.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */