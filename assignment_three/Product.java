public class Product {
    String productName;
    String brand;
    double price;

    public Product(String productName, String brand, double price) {
        this.productName = productName;
        this.brand = brand;
        this.price = price;
    }

    public String getProductName() {return this.productName;}
    public String getBrand() {return this.brand;}
    public double getPrice() {return this.price;}

}
