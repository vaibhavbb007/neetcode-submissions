class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orig = image[sr][sc];
        if(orig == color)
            return image;
        floodFillImage(image, sr, sc, image[sr][sc], color);
        return image;
    }


    private static void floodFillImage(int[][] image, int sr, int sc, int originalColor, int color) {
        int ROW = image.length;
        int COL = image[0].length;

        // base Case for not useful positions
        // out of bound || color no match || visited
        if ((Math.min(sc, sr) < 0) || (sr == ROW || sc == COL) || image[sr][sc] != originalColor) {
            // do nothing
            return;
        }

        // base case for useful positions
        // color match && not visited
        if (image[sr][sc] == originalColor) {
            image[sr][sc] = color;
        }

        floodFillImage(image, sr + 1, sc, originalColor, color);
        floodFillImage(image, sr - 1, sc, originalColor, color);
        floodFillImage(image, sr, sc + 1, originalColor, color);
        floodFillImage(image, sr, sc - 1, originalColor, color);

        return;
    }
}