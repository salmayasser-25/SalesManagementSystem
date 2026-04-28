package models;

public class Customer {
    private int customerId;
    private String customerName; 
    private String phone;
    private String email;
    private String address;

    public Customer() {}

    public Customer(String customerName, String phone, String email, String address) {
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Getters
    public int getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }  // كان getName()
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }

    // Setters
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }  // كان setName()
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setAddress(String address) { this.address = address; }
    
    @Override
    public String toString() {
        return customerName;
    }
}