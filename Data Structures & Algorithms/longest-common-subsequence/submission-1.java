class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();

        if(len1 == 0 || len2 == 0){
            return 0;
        }

        if(len1 == 1 && len2 == 1){
            return text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        }

        Map<String, Integer> cache = new HashMap<>();
        int result = memoization(text1, text2, cache);
        return result;
    }

    private int memoization(String str1, String str2, Map<String, Integer> cache){
        int counter = 0;
        if(str1.length() == 0 || str2.length() == 0){
            return 0;
        }
        
        String key = str1 + "|" + str2;
        if(cache.containsKey(key)){
            return cache.get(key);
        }

         if(str1.isEmpty() || str2.isEmpty()){
            return 0;
        }

        if(str1.charAt(0) ==  str2.charAt(0)){
            counter = 1 + memoization(str1.substring(1), str2.substring(1), cache);
        } else{
            counter = Math.max(memoization(str1.substring(1), str2, cache), memoization(str1, str2.substring(1), cache));
        }
        cache.put(key, counter);
        return counter;
    }
}
