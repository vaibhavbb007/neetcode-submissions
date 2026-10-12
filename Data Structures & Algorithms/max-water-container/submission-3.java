class Solution {
    public int maxArea(int[] heights) {
        int L = 0;
        int R = heights.length-1;
        int max = 0;
        while (L < R){
            // calculate current area.
            int width = R - L;
            int height = Math.min(heights[L], heights[R]);
            int area = height * width;
            max = Math.max(max, area);
            if(heights[L] <= heights[R]){
                L++;
            }else if (heights[L] >= heights[R]){
                R--;
            }
        }
        return max;
    }
}
