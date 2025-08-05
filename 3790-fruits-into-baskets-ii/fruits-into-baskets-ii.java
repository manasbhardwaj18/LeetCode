class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int num = fruits.length;
        int x = 0;
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                if(fruits[i]<=baskets[j]){
                    x++;
                    baskets[j] = -1;
                    break;
                }
            }
        }
        return num-x;
    }
}