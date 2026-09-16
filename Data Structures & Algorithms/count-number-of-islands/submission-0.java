class Solution {
    public int numIslands(char[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;

        if(ROW == 0 || COL == 0){
            return 0;
        }

        int totalCount = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == '1') {
                    findIsland(grid, i, j);
                    totalCount++;
                }
            }
        }

        return totalCount;
    }

    private void findIsland(char[][] grid, int r, int c) {
        int ROW = grid.length;
        int COL = grid[0].length;

        if (Math.min(r, c) < 0 || r == ROW || c == COL || grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '0';

        findIsland(grid, r + 1, c);
        findIsland(grid, r - 1, c);
        findIsland(grid, r, c + 1);
        findIsland(grid, r, c - 1);

        return;
    }
}
