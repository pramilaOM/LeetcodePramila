class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //TC compare and write p1,p2 or p backword at monst m(nums1)+n(nums2) so O(m+n)
        //SC all operation in place in nums1 O(1)
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;// fill from the end of nums1

         
        while (p1 >= 0 && p2 >= 0) {
            //largest will be moved to end
            if (nums1[p1] < nums2[p2]) {
                nums1[p] = nums2[p2];
                p2--;
            } else {
                nums1[p] = nums1[p1];
                p1--;
            }
            p--;

        }
        //copy nums2 of remaining element
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
        for (int n1 : nums1) {
            System.out.print(n1);
        }
        
    }
}