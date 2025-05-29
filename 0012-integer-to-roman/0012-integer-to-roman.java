class Solution {
    public String intToRoman(int num) {
        int[] val = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] sym = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        String result = "";
        for (int i = 0; i < 13; i++) {
            if (num == 0) {
                break;
            }
            int times = num / val[i];
            while (times > 0) {
                result = result + sym[i];
                times = times - 1;
            }
            num = num % val[i];
        }

        return result;
        
    }
}