class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        int [] prefix = new int[n+1];
        for(int i = 1; i <=n ; i++){
            prefix[i] = arr[i-1] + prefix[i-1];
        }
        for (int i = 0; i < arr.length; i++) {
            int arrSum = 0;
            for (int j = i; j < arr.length; j+=2) {
                arrSum += (prefix[j+1] - prefix[i]);
            }
            sum += arrSum;
        }
        return sum;
    }
}