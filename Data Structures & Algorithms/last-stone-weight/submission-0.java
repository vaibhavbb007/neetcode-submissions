class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0){
            return 0;
        }
        if(stones.length == 1){
            return stones[0];
        }

        int right = stones.length - 1;
        while(right > 0){
            mergeSort(stones, 0, right);
            int biggest = stones[right];
            int secondBiggest = stones[right-1];
            int combinedElement = biggest - secondBiggest;
            stones[right-1] = combinedElement;
            right--;
        }
        return stones[right];
    }

    public void mergeSort(int[] arr, int start, int end){
        if(end-start+1 <= 1){
            return;
        }

        int mid = (end + start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end){
        int leftSize = (mid - start) + 1;
        int rightSize = (end - mid);
        int[] L = new int[leftSize];
        int[] R = new int[rightSize];

        int k = start;

        //data copy
        for(int i = 0; i < leftSize; i++){
            L[i] = arr[start+i];
        }

        for(int i = 0; i < rightSize; i++){
            R[i] = arr[mid+1+i];
        }

        int leftCounter = 0;
        int rightCounter = 0;
        while(leftSize>leftCounter && rightSize>rightCounter){
            if (L[leftCounter] <= R[rightCounter]) {
                arr[k] = L[leftCounter];
                leftCounter++;
            } else {
                arr[k] = R[rightCounter];
                rightCounter++;
            }
            k++;
        }

        while(leftCounter < leftSize){
            arr[k] = L[leftCounter];
            k++;
            leftCounter++;
        }

         while(rightCounter < rightSize){
            arr[k] = R[rightCounter];
            k++;
            rightCounter++;
        }

    }

}
