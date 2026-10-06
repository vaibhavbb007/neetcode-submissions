class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int L = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int R = 0; R < nums.length; R++){
            sum += nums[R];
            while(sum >= target){
                minLength = Math.min(R-L+1, minLength);
                sum -= nums[L];
                L++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}