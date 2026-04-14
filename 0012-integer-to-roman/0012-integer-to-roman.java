class Solution {
    public String intToRoman(int num) {
        int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 13; i++) {
            if (num >= value[i]) {
                int times = num / value[i];
                while (times-- > 0) {
                    sb = sb.append(symbol[i]);
                }

                num = num % value[i];
            }

        }
        return sb.toString();
    }
}