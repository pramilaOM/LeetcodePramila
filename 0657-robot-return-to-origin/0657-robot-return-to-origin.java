class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char s : moves.toCharArray()) {
            if (s == 'U')
                y++;
            else if (s == 'D')
                y--;
            else if (s == 'R')
                x++;
            else
                x--;
        }
        return x == 0 && y == 0;

    }
}