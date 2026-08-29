class ListNode {
    int val; 
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}

class MyLinkedList {
    private ListNode head;
    private int size;

    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }
    
    public int get(int index) {
        if(index >= size){
            return -1;
        }

        ListNode cur = head.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        if(head == null || head.next == null){
            return;
        }

        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        ListNode newNode = new ListNode(val);
        current.next = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        ListNode current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >=  size ){
            return;
        }
        ListNode current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */