class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len = candies.length;
        List<Boolean> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int n : candies) {
            if (n > max) {
                max = n;
            }
        }

        for (int i = 0; i < len; i++) {

            ans.add((candies[i] + extraCandies) >= max);
        }

        return ans;

    }
}