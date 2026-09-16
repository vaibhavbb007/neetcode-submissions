class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(getMaxArea(grid, i, j), maxArea);
                }
            }
        }

        return maxArea;
    }

    private static int getMaxArea(int[][] grid, int r, int c) {

        int ROW = grid.length;
        int COL = grid[0].length;

        if (Math.min(r, c) < 0 || r == ROW || c == COL || grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 0;

        int area = 1;

        area += getMaxArea(grid, r + 1, c);
        area += getMaxArea(grid, r - 1, c);
        area += getMaxArea(grid, r, c + 1);
        area += getMaxArea(grid, r, c - 1);

        return area;
    }
}
