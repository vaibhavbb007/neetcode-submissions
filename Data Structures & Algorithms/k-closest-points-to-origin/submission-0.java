class Solution {

    private class Node {
        int value;
        int index;

        public Node(int value, int data) {
            this.value = value;
            this.index = data;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        
        if (points.length == 0 || k == 0) {
            return new int[][] {{0, 0}};
        }

        PriorityQueue<Node> indexes = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.value, n2.value));

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int val = (x * x) + (y * y);
            indexes.add(new Node(val, i));
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            if (!indexes.isEmpty()) {
                Node node = indexes.poll();
                result[i] = points[node.index];
            }
        }
        return result;
    }
}
