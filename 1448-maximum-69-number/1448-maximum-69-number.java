class Solution {
    public int maximum69Number(int num) {
        int place = 0;
        int index = -1;
        int temp = num;

        while (temp > 0) {
            int remain = temp % 10;
            if (remain == 6) {
                index = place;
            }
            temp /= 10;
            place++;
        }
        if (index == -1)
            return num;

        return num + 3 * (int) Math.pow(10, index);
    }
}