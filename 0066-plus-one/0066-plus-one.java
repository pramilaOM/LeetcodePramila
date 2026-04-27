import java.math.BigInteger;

class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int d : digits) {
            sb.append(d);
        }

        // Convert to BigInteger and add 1
        BigInteger num = new BigInteger(sb.toString());
        num = num.add(BigInteger.ONE);

        // Convert back to array
        String result = num.toString();
        int[] ans = new int[result.length()];

        for (int i = 0; i < result.length(); i++) {
            ans[i] = result.charAt(i) - '0';
        }

        return ans;
    }
}