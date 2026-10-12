class Solution {
    public int removeDuplicates(int[] nums) {
        int L = 0;
        int R = L + 1;
        int lim = 1;
        while (R < nums.length){
            if(nums[L] == nums[R]){
               
                if(lim > 0){
                    L++;
                    nums[L] = nums[R];
                    lim--;
                }
            } else if (nums[L] != nums[R]){
                L++;
                nums[L] = nums[R];
                lim = 1;
            }
            R++;
        }
        return L + 1;
    }
}