class Solution {
    public int lastStoneWeight(int[] stones) {

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
