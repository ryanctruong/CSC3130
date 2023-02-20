public class AList {
    public Product[] items;
    public int maxSize;
    public int size;

    public AList(){
        this.maxSize = 10;
        this.items = new Product[maxSize];
        this.size = 0; //current size of the array
    }

    public void listAdd(Product p){
        if(size == items.length){ //if array is full, create a new array
            Product[] newItems = new Product[size+1];
            for(int i = 0; i < items.length; i++){
                newItems[i] = items[i]; //transferring elements from one array to another
            }
            items = newItems; // items are pointing to items still, we need to ensure that it points to newItems
        }
        items[size] = p;
        size++;
    }

    public void listRemove(int pos){
        Product[] newItems = new Product[size-1];
        for(int i = 0; i < newItems.length; i++){
            if(i != pos-1){
                newItems[i]= items[i];
            }
        }
        items = newItems;
        size--;
    }

    public String toString(){
        int i = 1;
        for (Product item : items) {
            if (item != null) {
                System.out.println(i + " Product Name: " + item.getProductName()
                        + ", Brand: " + item.getBrand() + ", Price: $" + item.getPrice());
            }
            i++;
        }
        return "";
    }
}
