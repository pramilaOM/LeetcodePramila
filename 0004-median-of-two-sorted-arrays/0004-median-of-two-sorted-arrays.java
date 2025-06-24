class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int total = (m + n + 1) / 2;

        int left = 0, right = m;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = total - i;

            int n1left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int n1right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int n2left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int n2right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if(n1left <= n2right && n2left <=n1right){
                if((m+n)%2 ==0){
                    return (Math.max(n1left,n2left)+Math.min(n1right,n2right))/2.0;
                }else{
                    return Math.max(n1left,n2left);
                }
            }else if(n1left > n2right){
                right = i-1;
            }else{
                left = i+1;
            }

        }
        throw new IllegalArgumentException("Input invalid");
    }
}