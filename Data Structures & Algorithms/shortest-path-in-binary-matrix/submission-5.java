class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        if(grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1 || grid[ROW - 1][COL - 1] == 1){
            return -1;
        }       
        int[][] visited = new int[ROW][COL];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[2]);
        visited[0][0] = 1;

        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                int r = pair[0], c = pair[1];

                if (r == ROW - 1 && c == COL - 1) {
                    return length;
                }
                // all neighbors including diagonal values = 8
                int[][] neighbors = { { r, c + 1 }, { r, c - 1 }, { r + 1, c }, { r - 1, c }, { r - 1, c - 1 },
                        { r - 1, c + 1 }, { r + 1, c - 1 }, { r + 1, c + 1 } };

                for (int j = 0; j < 8; j++) {
                    int newR = neighbors[j][0], newC = neighbors[j][1];
                    // base conditions
                    if (Math.min(newR, newC) < 0 || newR == ROW || newC == COL || visited[newR][newC] == 1
                            || grid[newR][newC] == 1) {
                        continue;
                    }
                    queue.add(neighbors[j]);
                    visited[newR][newC] = 1;
                }
            }
            if(!queue.isEmpty()){
                length++;
            }
        }

        return -1;
    }
}