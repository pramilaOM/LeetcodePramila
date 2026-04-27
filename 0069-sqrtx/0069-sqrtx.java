class Solution {
    public int mySqrt(int x) {
         if (x == 0) return 0;

        int i = 1;
        while ((long) i * i <= x) {  // use long to avoid overflow
            i++;
        }

        return i - 1;
    }
}