class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        /*
        1. find the max in piles
        2. for binary search range will be 1 to max
        3. select a mid and check that value is satisying the requirement
            if yes go lower
            if no go higher
        */
        int max = 0;
        for( int i = 0; i < piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }

        int left = 1;
        int right = max;
        int solution = max;
        while(left <= right){
            int mid = (left + right)/2;
            if(isValidSolution(piles,mid,h)){
                right = mid - 1;
                solution = mid;
            } else {
                left = mid + 1;
            }
        }
        return solution;
    }

    private boolean isValidSolution(int[] piles, int rate, int maxHours){
        long computedHours = 0;
        for(int i = 0; i < piles.length; i ++){ 
            computedHours += Math.ceil((double)piles[i] / rate);
        }
        return computedHours <= maxHours;
    }
}
