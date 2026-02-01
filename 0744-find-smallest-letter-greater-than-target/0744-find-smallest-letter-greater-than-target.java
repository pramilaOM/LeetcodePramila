class Solution {

    private int binarySearch(char[] letters, char target) {
        int n = letters.length;
        int l = 0, r = n - 1;
        int position = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (letters[mid] > target) {
                position = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return position;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int idx = binarySearch(letters, target);

        if (idx == letters.length) {
            return letters[0];
        }

        return letters[idx];
    }
}