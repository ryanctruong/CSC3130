public class DLNode {
    public Product items;
    public DLNode next;
    public DLNode prev;

    public DLNode(Product items){
        this.items = items;
        this.next = null;
        this.prev = null;
    }
}

class DLList{
    public DLNode head;
    public DLNode tail;

    public DLList(){
        this.head = null;
        this.tail = null;
    }

    public void listAdd(Product p){
        DLNode newItems = new DLNode(p);
        if(head == null){
            head = newItems;
        }
        else{
            newItems.prev = tail;
            tail.next = newItems;
        }
        tail = newItems;
    }

    public void listRemove(int pos) {
        if (head == null)
            return;
        DLNode current = head;

        if (pos == 1) {
            head = current.next;
            head.prev = null;
            return;
        }

        current.prev.next = current.next;

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        current.next = null;
        current.prev = null;

        //concept is similar to SLList class.
    }

    public void printList() {
        DLNode current = head;
        while (current != null) {
            System.out.println(current.items.productName + ", " + current.items.price + ", $"+ current.items.getPrice());
            current = current.next;
        }
    }
}

