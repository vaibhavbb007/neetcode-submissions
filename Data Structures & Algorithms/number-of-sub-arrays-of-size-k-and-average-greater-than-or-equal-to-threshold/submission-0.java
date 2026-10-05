class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        if(arr.length < k){
            return 0;
        }
        threshold *= k;
        int L = 0;
        int counter = 0;
        int sum = 0;
        for(int R = 0; R < arr.length; R++){
            sum += arr[R];
            if(R - L + 1 == k){
                if(sum >= threshold){
                    counter++;
                }
                sum -= arr[L];
                L++;
            }
        }
        return counter;
    }
}