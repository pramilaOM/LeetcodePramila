//https://www.youtube.com/watch?v=OxUFaTwKp7E 
class Solution {
    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        if(x < 2){
            return x;
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            int temp = x / mid;
            if (temp == mid) {
                return mid;
            } else if (temp < mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}