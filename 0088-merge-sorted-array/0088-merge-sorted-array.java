class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //TC O(m+n)log(m+n) 
        //SC Sorting inplace no extra space hence O(1)
        // add num2 in num1 TC O(n)
        int index = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[index];
            index++;
        }
        //num1 has m+n element
        // sort the element TC O(m+n)log(m+n)
        Arrays.sort(nums1);// SC O(1)
        for (int n1 : nums1) {
            System.out.print(n1 + " ");
        }
    }
}