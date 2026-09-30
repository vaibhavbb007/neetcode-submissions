class Solution {
    public int uniquePaths(int m, int n) {
        int row = m, col = n;
        int[] previous = new int[col];
        for (int i = row - 1; i >= 0; i--){
            int[] current = new int[col];
            current[col-1] = 1;
            for(int j = col-2; j >= 0; j--){
                current[j] = current[j+1] + previous[j];
            }
            previous = current;
        }
        return previous[0];
    }
}
