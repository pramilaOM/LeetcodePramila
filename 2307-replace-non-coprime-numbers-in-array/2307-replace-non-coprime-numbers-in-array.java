class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            while (!result.isEmpty()) {
                int prev = result.get(result.size() - 1);
                int g = gcd(prev, num);
                if (g == 1) {
                    break;
                }
                result.remove(result.size() - 1);
                long lcm = (long) prev / g * num;
                num = (int) lcm;
            }
            result.add(num);
        }
        return result;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}