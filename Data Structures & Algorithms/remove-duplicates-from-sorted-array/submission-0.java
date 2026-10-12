class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums.length == 1){
            return 1;
        }

        int L = 0;
        int R = L + 1;

        while(R < nums.length){
            if(nums[L] == nums[R]){
                R++;
            } else if (nums[L] != nums[R]){
                L++;
                nums[L] = nums[R];
                R++;
            }
        }
        return L + 1;
    }
}