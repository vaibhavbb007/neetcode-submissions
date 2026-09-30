class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] cache = new int[obstacleGrid.length][obstacleGrid[0].length];
        int paths = memoization(obstacleGrid, cache, 0, 0);
        return paths;
    }

    private int memoization(int[][] obstacleGrid, int[][] cache, int r, int c){
        int ROW = obstacleGrid.length;
        int COL = obstacleGrid[0].length;
        int count = 0;
        if(r == ROW || c == COL || obstacleGrid[r][c]==1){
            return 0;
        }
        if(cache[r][c]!=0){
            return cache[r][c];
        }
        if(r == ROW-1 && c == COL-1){
            return 1;
        }

        count += memoization(obstacleGrid, cache, r+1, c) + memoization(obstacleGrid, cache, r, c+1);
        cache[r][c] = count;
        return count;
    }
}