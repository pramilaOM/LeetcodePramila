class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        int[] data = new int[2001];

        for (int x : arr) {
            data[x + 1000]++;
        }
        Arrays.sort(data);

        for (int i = 1; i < 2001; i++) {
            if (data[i] == 0)
                continue;

            int idx = Math.abs(data[i]);

            if (data[idx] < 0) {
                return false;
            }

            data[idx] = -1;
        }

        return true;
    }
}