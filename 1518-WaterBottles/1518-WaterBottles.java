// Last updated: 10/1/2025, 6:34:58 PM
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drunk = 0;
        int empty = 0;
        while(numBottles > 0){
            drunk += numBottles;
            empty += numBottles;

            numBottles = empty/numExchange ;
            empty = empty % numExchange;
        }
        return drunk;
    }
}