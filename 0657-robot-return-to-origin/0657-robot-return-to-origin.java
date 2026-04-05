class Solution {
    public boolean judgeCircle(String moves) {
        //Alternate approach - Find count of U,D,L and R then check if they are equal
        int up = 0, down = 0, left = 0, right = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                up++;
            } else if (move == 'D') {
                down++;
            } else if (move == 'L') {
                left++;
            } else if (move == 'R') {
                right++;
            }
        }

        return up == down && left == right;
    }
}