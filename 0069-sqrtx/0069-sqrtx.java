//https://www.youtube.com/watch?v=OxUFaTwKp7E 
class Solution {
    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }
        int l = 0;
        int r = x;
        while (l < r) {
            int mid = (l + r) / 2;
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