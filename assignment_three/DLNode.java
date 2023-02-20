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

    public void listRemove(int pos){

    }
}

