package models;

public class Product {
    private int productId;
    private String productName;  
    private double price;
    private int quantity;
    private String description;  

    public Product() {}

    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public int getProductId() { return productId; }
    public String getProductName() { return productName; } 
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getDescription() { return description; }

    // Setters
    public void setProductId(int productId) { this.productId = productId; }
    public void setProductName(String productName) { this.productName = productName; }  
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setDescription(String description) { this.description = description; }
    
    @Override
    public String toString() {
        return productName + " - $" + price + " (Stock: " + quantity + ")";
    }
}