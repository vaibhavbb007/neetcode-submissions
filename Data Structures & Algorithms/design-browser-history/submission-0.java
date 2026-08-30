 private class ListNode {
        String site;
        ListNode prev;
        ListNode next;

        ListNode(String site, ListNode prev, ListNode next){
            this.site = site;
            this.prev = prev;
            this.next = next;
        }
}


class BrowserHistory {

    private ListNode current;
    int steps;

    public BrowserHistory(String homepage) {
        current = new ListNode(homepage, null, null);
        steps = 0;
    }
    
    public void visit(String url) {
        ListNode newNode = new ListNode(url, current, null);
        current.next = newNode;
        current = newNode;
    }
    
    public String back(int steps) {
        while(steps > 0 && current.prev != null){
            current = current.prev;
            steps--;
        }
        return current.site;
    }
    
    public String forward(int steps) {
        while(steps > 0 && current.next != null){
            current = current.next;
            steps--;
        }
        return current.site;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */