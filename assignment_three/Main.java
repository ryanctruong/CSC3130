public class Main {

    public static void main(String[] args) {
        AList productList = new AList();
        Product p = new Product("Nike Shoes", "Nike", 20.49);

        for(int i = 0; i < 20; i++){
            productList.listAdd(p);
        }
//        productList.listRemove(3);
//        productList.toString();

        SLList list = new SLList();

        list.listAdd(new Product("Orange", "Walmart", 2.99));
        list.listAdd(new Product("Apple", "Kroger", 0.99));
        list.listAdd(new Product("Banana","Target", 1.29));

        list.listRemove(2);

        list.printList();


    }
}
