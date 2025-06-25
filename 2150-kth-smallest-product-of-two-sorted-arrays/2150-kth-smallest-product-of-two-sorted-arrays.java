class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -100_000L * 100_000L, right = 100_000L * 100_000L;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countLessOrEqual(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private long countLessOrEqual(int[] A, int[] B, long target) {
        long count = 0;
        for (int a : A) {
            if (a > 0) {
                // Binary search for largest b where a * b <= target
                int l = 0, r = B.length;
                while (l < r) {
                    int m = l + (r - l) / 2;
                    if ((long) a * B[m] <= target) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                count += l;
            } else if (a < 0) {
                // Binary search for smallest b where a * b <= target
                int l = 0, r = B.length;
                while (l < r) {
                    int m = l + (r - l) / 2;
                    if ((long) a * B[m] <= target) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                count += B.length - l;
            } else {
                if (target >= 0) {
                    count += B.length;
                }
            }
        }
        return count;
    }
}
