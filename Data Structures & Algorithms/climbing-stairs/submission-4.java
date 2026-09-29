class Solution {

    public int climbStairs(int n) {
        int[] cache = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            cache[i] = -1;
        }
        return dpSolution(n, cache);
    }

    private int dpSolution(int n, int[] cache){
        int counter = 0;
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(cache[n] != -1){
            return cache[n];
        }
        counter += dpSolution(n-1, cache);
        counter += dpSolution(n-2, cache);
        cache[n] = counter;

        return counter;
    }
}
