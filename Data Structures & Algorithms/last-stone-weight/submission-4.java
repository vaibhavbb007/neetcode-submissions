class Solution {
    public int lastStoneWeight(int[] stones) {

        if(stones.length == 0){
            return 0;
        }

        if(stones.length == 1){
            return stones[0];
        }

        if(stones.length == 2){
            return Math.abs(stones[0]-stones[1]);
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int nums : stones) {
            maxHeap.add(nums);
        }

        while (maxHeap.size() > 1) {
            int biggest = maxHeap.poll();
            int secondBiggest = maxHeap.poll();
            int result = biggest - secondBiggest;
            if (result != 0) {
                maxHeap.add(result);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
