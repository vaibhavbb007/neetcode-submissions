class KthLargest {

    private List<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new ArrayList<>();
        heap.add(0); // dummy element at index 0

        for (int num : nums) {
            heap.add(num);
        }
        heapify(heap);
        while(heap.size()-1 > k){
            pop();
        }
    }
    
    public int add(int val) {
        insert(val);
        if(heap.size()-1>k){
            pop();
        }
        return heap.get(1);
    }


    public void perculateDown(int i){
          while(2*i < heap.size()){
                if(2*i+1 < heap.size() && heap.get(2*i+1) < heap.get(2*i) && heap.get(i) > heap.get(2*i+1)){
                    int tmp = heap.get(i);
                    heap.set(i, heap.get(2*i+1));
                    heap.set(2*i+1, tmp);
                    i = 2*i+1;
                } else if (heap.get(i) > heap.get(2*i)){
                    int tmp = heap.get(i);
                    heap.set(i, heap.get(2*i));
                    heap.set(2*i, tmp);
                    i = 2*i;
                } else{
                    break;
                }
            }
    }

    public void pop(){
        if (heap.size() == 1) {
            return;
        }
        if (heap.size() == 2) {
            heap.remove(1);
            return;
        }
        int i = 1;
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        perculateDown(i);
    }

    public void insert(int val){
        if (heap.size() == 1) {
            heap.add(val);
            return;
        }
        heap.add(val);
        int i = heap.size() - 1;
        // perculate up
        while (i > 1 && heap.get(i) < heap.get(i / 2)) {
            int temp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, temp);
            i = i / 2;
        }
    }


    public void heapify(List<Integer> heap){
        if(heap.size()==1){
            return;
        }
        if(heap.size()==2){
            return;
        }
        int curr =(heap.size()-1)/2;
        while(curr > 0){
            int i = curr;
            perculateDown(i);
            curr--;
        }
    }
}
