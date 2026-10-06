class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();

        int L = 0;
        int maxLen = 0;

        for (int R = 0; R < s.length(); R++) {

            // 1. Add current character to the window
            char current = s.charAt(R);
            freq.put(current, freq.getOrDefault(current, 0) + 1);

            // 2. Find the highest frequency inside the window
            int maxFreq = getMaxFreqInMap(freq);

            // 3. Shrink until window becomes valid
            while ((R - L + 1) - maxFreq > k) {
                char leftChar = s.charAt(L);
                freq.put(leftChar, freq.get(leftChar) - 1);
                L++;

                maxFreq = getMaxFreqInMap(freq);
            }

            // 4. Window is now valid
            maxLen = Math.max(maxLen, R - L + 1);
        }

        return maxLen;
    }

    private int getMaxFreqInMap(Map<Character, Integer> freq){
        int maxFreq = 0;

        for(Map.Entry<Character, Integer> entry : freq.entrySet()){
            int val = entry.getValue();
            maxFreq = Math.max(val, maxFreq);
        }

        return maxFreq;
    }
}
