class Solution {
    public int maxDistance(String s, int k) {

        int maxMD = 0;
        int east = 0, west = 0, north = 0, south = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'E')
                east++;
            else if (c == 'W')
                west++;
            else if (c == 'N')
                north++;
            else if (c == 'S')
                south++;

            int currMD = Math.abs(east - west) + Math.abs(north - south);

            int steps = i + 1;
            int wasted = steps - currMD;
            int extra = Math.min(2 * k, wasted);
            int finalCurrMd = currMD + extra;
            maxMD = Math.max(maxMD, finalCurrMd);
        }
        return maxMD;

    }
}