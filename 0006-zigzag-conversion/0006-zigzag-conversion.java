class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] row = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            row[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean isDown = false;
        for (char c : s.toCharArray()) {
            row[currRow].append(c);
            if(currRow ==0 || currRow == numRows-1){
                isDown = !isDown;
            }
            currRow += isDown ? 1 : -1;
        }
        StringBuilder result= new StringBuilder();
        for(StringBuilder s1 : row){
            result.append(s1);
        } 
        return result.toString();
    }
}