class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        for (int num : fruits) {
            for (int i = 0; i < baskets.length; i++) {
                if (baskets[i] >= num) {
                    baskets[i] = 0;
                    count++;
                    break;
                }
            }

        }
        return fruits.length - count;
    }
}