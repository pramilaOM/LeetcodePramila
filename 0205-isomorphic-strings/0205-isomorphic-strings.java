class Solution {
    public boolean isIsomorphic(String s, String t) {
        //T.C : O(n)
        //S.C : O(1) -> Take array of size 256 to handle all ASCII characters instead of taking map

        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (arr1[c1] != -1 && arr1[c1] != c2 || arr2[c2] != -1 && arr2[c2] != c1) {
                return false;
            }

            arr1[c1] = c2;
            arr2[c2] = c1;
        }

        return true;

    }
}