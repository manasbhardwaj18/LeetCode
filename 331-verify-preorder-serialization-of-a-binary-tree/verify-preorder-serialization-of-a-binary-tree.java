class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] pre=preorder.split(",");
        int c1=0,c2=0;
        for(int i=0;i<pre.length;i++){
            if(c2+1==c1){
                return false;
            }
            if(pre[i].equals(Character.toString('#'))){
                c1++;
            }
            else{
                c2++;
            }
        }
        return (c2+1)==c1;  
    }
}