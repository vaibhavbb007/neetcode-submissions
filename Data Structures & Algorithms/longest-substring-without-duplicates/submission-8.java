class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if(s == null){
            return 0;
        }
        Set<Character> seen = new HashSet<>();
        int L = 0;
        int maxSubArray = 0;
        for(int R = 0; R < s.length(); R++){
            while(seen.contains(s.charAt(R))){
                seen.remove(s.charAt(L));
                L++;
            }
            seen.add(s.charAt(R));
            maxSubArray = Math.max((R-L+1), maxSubArray);
        }
        return maxSubArray;
    }
}
