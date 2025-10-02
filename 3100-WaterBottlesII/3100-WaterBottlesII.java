// Last updated: 10/2/2025, 2:38:34 PM
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drunk = numBottles;
        int empty = numBottles;
        while(empty >= numExchange){
            empty -= numExchange;
            numExchange++;
            drunk++;
            empty++;
        }
        return drunk;
    }
}