class Solution {
    private static final double EPSILON = 0.1; // 0.01 or 0.001 will also work
    // Tolerance for floating-point comparison. To avoid floating point precission errors 

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return solve(nums);
    }

    private boolean solve(List<Double> cards) {
        if (cards.size() == 1) {
            return Math.abs(cards.get(0) - 24) <= EPSILON;
        }

        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                if (i == j) continue;

                List<Double> temp = new ArrayList<>();
                for (int k = 0; k < cards.size(); k++) {
                    if (k != i && k != j) {
                        temp.add(cards.get(k));
                    }
                }

                double a = cards.get(i);
                double b = cards.get(j);
                List<Double> possibleVals = new ArrayList<>();
                possibleVals.add(a + b);
                possibleVals.add(a - b);
                possibleVals.add(b - a); //b-a is not required, our i and j for loop will take care of it
                possibleVals.add(a * b);

                if (Math.abs(b) > 0.0) {
                    possibleVals.add(a / b);
                }
                if (Math.abs(a) > 0.0) {
                    possibleVals.add(b / a); //b/a is not required, our i and j for loop will take care of it
                }

                for (double val : possibleVals) {
                    temp.add(val); // Do
                    if (solve(temp)) return true; // Explore
                    temp.remove(temp.size() - 1); // Undo
                }
            }
        }

        return false;
    }
}