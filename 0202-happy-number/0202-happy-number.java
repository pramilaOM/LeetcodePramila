class Solution {
    public boolean isHappy(int n) {

        HashSet set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            int sum = 0;
            int temp = n;
            while (temp > 0) {
                int digit = temp % 10;
                sum += digit * digit;
                temp = temp / 10;
            }
            n = sum;
        }
        return true;
    }
}