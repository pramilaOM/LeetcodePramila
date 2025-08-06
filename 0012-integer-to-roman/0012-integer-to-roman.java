class Solution {
    public String intToRoman(int num) {
        String[] sym = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] val = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 13; i++) {
            if (num == 0)
                break;
            int times = num / val[i];

            while (times-- > 0) {
                result.append(sym[i]);
            }
            num = num % val[i];
        }
        return result.toString();
    }
}