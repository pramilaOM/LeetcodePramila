class Solution {
 // TOP-LEFT, BOTTOM-RIGHT, TOP-RIGHT, BOTTOM-LEFT
    int [][]directions = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}}; // stored indexes are in such a way that every next indexes are clockwise to the current index
    // topLeft --> topRight, bottomRight --> bottomLeft, topRight --> bottomRight, bottomLeft --> topLeft

    private boolean inside(int row, int col, int [][]grid) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }

    Integer [][][][]cache;

    private int exploreWithDirection(int row, int col, int [][]grid, int dir, int turns) {
        // if(!inside(row, col, grid)) return 0;
        int newRow = row + directions[dir][0], newCol = col + directions[dir][1];
        int currentValue = grid[row][col];
        int longestLength = 1;
        if(cache[row][col][dir][turns] != null) return cache[row][col][dir][turns];
        if(inside(newRow, newCol, grid)) {
            if(currentValue == 1 || currentValue == 0) {
                if(grid[newRow][newCol] == 2) {
                    longestLength = Math.max(longestLength, 1 + exploreWithDirection(newRow, newCol, grid, dir, turns));
                } 
            }
            if(currentValue == 2) {
                if(grid[newRow][newCol] == 0) {
                    longestLength = Math.max(longestLength, 1 + exploreWithDirection(newRow, newCol, grid, dir, turns));
                }
            }
        }
        if(currentValue == 0 || currentValue == 2) {
            int turnedDir = (dir + 1) % 4;
            int newTurnedRow = row + directions[turnedDir][0], newTurnedCol = col + directions[turnedDir][1];
            if(inside(newTurnedRow, newTurnedCol, grid) && turns > 0) {
                // System.out.println("turned:" + dir + " " + turnedDir);
                if(currentValue == 0) {

                    if(grid[newTurnedRow][newTurnedCol] == 2) {
                        longestLength = Math.max(longestLength, 1 + exploreWithDirection(newTurnedRow, newTurnedCol, grid, turnedDir, turns - 1));
                    } 
                }
                if(currentValue == 2) {
                    if(grid[newTurnedRow][newTurnedCol] == 0) {
                        longestLength = Math.max(longestLength, 1 + exploreWithDirection(newTurnedRow, newTurnedCol, grid, turnedDir, turns - 1));
                    }
                }
            }
        }

        return cache[row][col][dir][turns] =  longestLength;
    }


    public int lenOfVDiagonal(int[][] grid) {

        int maxDiagonalLength = 0, row = grid.length, col = grid[0].length;
        cache = new Integer[row][col][4][2];
        
        for(int i = 0; i < row; i += 1) {
            for(int j = 0; j < col; j += 1) {
                if(grid[i][j] == 1) {
                    // System.out.println(" start " + i+ " " + j);
                    for(int dir = 0; dir < 4; dir += 1) {
                        maxDiagonalLength = Math.max(
                            maxDiagonalLength,
                            exploreWithDirection(i, j, grid, dir, 1) 
                        );
                    }
                }
            }
        }
        return maxDiagonalLength;
    }
}