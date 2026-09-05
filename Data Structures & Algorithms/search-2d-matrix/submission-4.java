class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        
        int row = matrix.length-1;
        int col = matrix[0].length-1;

        if(row+1 == 0 && col+1 == 0){
            return false;
        }

        for (int i = 0; i <= row; i++){
            if(i < row && target >= matrix[i+1][0]) {
                continue;
            }
             if(target == matrix[i][0]) {
                return true;
            }
            
            int left = 1;
            int right = col;
            while(left <= right) {
                int mid = (left + right)/2;
                if(target > matrix[i][mid]){
                    left = mid + 1;
                } else if (target < matrix[i][mid]){
                    right = mid-1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}
