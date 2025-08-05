class Solution {
    public boolean canConstruct(String s, int k) {
        //s = "true", k = 4 for this case
        if (s.length() == k) {
            return true;
        }
        if (s.length() < k) {
            return false;
        }
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= k;
    }
}