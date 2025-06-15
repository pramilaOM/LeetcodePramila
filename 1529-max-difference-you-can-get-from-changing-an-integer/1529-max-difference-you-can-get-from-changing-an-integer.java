class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        char startMax = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                startMax = s.charAt(i);
                break;
            }
        }

        String maxString = (startMax != 0) ? s.replace(startMax, '9') : s;
        int max = Integer.valueOf(maxString);

        char startMin = 0;
        if (s.charAt(0) != '1') {
            startMin = s.charAt(0); // replace first digit (≠ '1') with '1'
        } else {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                    startMin = s.charAt(i); // replace inner digit (≠ '0' or '1') with '0'
                    break;
                }
            }
        }
        String minString = (startMin != 0) ? s.replace(startMin, (s.charAt(0) != '1') ? '1' : '0') : s;
        int min = Integer.valueOf(minString);

        return max - min;

    }
}