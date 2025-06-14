class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         int totalGas = 0, totalCost = 0;
        for (int n : gas) {
            totalGas += n;
        }
        for (int n : cost) {
            totalCost += n;
        }

        if (totalGas < totalCost) {
            return -1;
        }
        int tank = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return start;
        
    }
}