class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] data = new int[2001];

        for (int x : arr) {
            data[x + 1000]++;
        }
        Arrays.sort(data);

        for (int i = 1; i < 2001; i++) {
            if (data[i] != 0 && data[i] == data[i - 1]) {
                return false;
            }
        }

        return true;
    }
}