class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 1 && nums[0] == 1){
            return 1;
        }
        if(nums.length == 1 && nums[0] == 0){
            return 0;
        }
        int max = 0;
        int counter = 0;
        int leastOneStreak = 0;
        for (int i = 0; i < nums.length-1; i++){
            if(nums[i] == 1 && nums[i+1] == 1){
                counter++;
                if(max < counter){
                    max = counter;
                }
            }else{
                counter = 0;
                if(nums[i] == 1){
                    leastOneStreak++;
                }
            }
        }

        if (max > 0)
            return max + 1;
        else if (leastOneStreak > 0)
            return 1;
        else 
            return 0;
    }
}