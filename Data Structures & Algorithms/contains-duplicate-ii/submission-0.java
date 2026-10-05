class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int updated_k = k + 1;

        Set<Integer> window = new HashSet<>();

        int L = 0;

        for(int R = 0; R < nums.length; R++){
            if(R-L + 1 > updated_k){
                window.remove(nums[L]);
                L++;
            }
            if(window.contains(nums[R])){
                return true;
            }
            window.add(nums[R]);
        }

        return false;
    }
}