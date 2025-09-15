class Solution {
    public int trailingZeroes(int n) {
        //find no of 5 and return because 2 * 5 will give 0
        int count = 0;
        while(n > 0){
            n= n/5;
            count = count+n;
        }
        return count;
    }
}