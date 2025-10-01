class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;

        while(numBottles>=numExchange){
            int changed = numBottles/numExchange;
            int rem = numBottles%numExchange;
            ans += changed ;
            numBottles = changed + rem;
        }
        return ans ;
    }
}