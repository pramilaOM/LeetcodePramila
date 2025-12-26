class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalKamai = 0;
        int totalKharcha = 0;
        for (int a : gas) {
            totalKamai += a;
        }

        for (int b : cost) {
            totalKharcha += b;
        }

        if (totalKamai < totalKharcha)
            return -1;

        int total = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            total = total + gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                index = i + 1;
            }

        }
        return index;
    }
}