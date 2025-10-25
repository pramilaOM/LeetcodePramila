class Solution {
    public int totalMoney(int n) {
        int start_monday = 1;
        int result = 0;
        while (n > 0) {
            int monday_money = start_monday;
            for (int day = 1; day <= Math.min(n, 7); day++) {
                result += monday_money;
                monday_money++;
            }
            n -= 7;
            start_monday++;
        }

        return result;

    }
}