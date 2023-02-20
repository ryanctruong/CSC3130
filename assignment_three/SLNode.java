public class SLNode {
    public Product items;
    public SLNode next;
    public SLNode(Product items){
        this.items = items;
        this.next = null;
    }
}

class SLList{
    public SLNode head;
    public SLNode tail;

    public SLList(){
        this.head = null;
        this.tail = null;
    }

    public void listAdd(Product p){
        SLNode newItems = new SLNode(p);
        if(head == null){
            head = newItems;
        }
        else{
            tail.next = newItems;
        }
        tail = newItems;
    }

    public void listRemove(int pos){
        if (head == null)
            return;
        SLNode temp = head;

        if (pos == 0) {
            head = temp.next;
            return;
        }

        for (int i = 0; temp != null && i < pos - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        temp.next = temp.next.next;
        //https://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
        // im not sure how to do it so here's the code that I got this code from!
    }

    public void printList() {
        SLNode curr = head;
        while (curr != null) {
            System.out.println(curr.items.productName + ", " + curr.items.price + ", $"+ curr.items.getPrice());
            curr = curr.next;
        }
    }
}
