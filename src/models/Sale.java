package models;

import java.util.Date;

public class Sale {
    private int saleId;
    private String customerName;
    private Date saleDate;
    private double totalAmount;

    public Sale(int saleId, String customerName, Date saleDate, double totalAmount) {
        this.saleId = saleId;
        this.customerName = customerName;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }

    public Sale() {
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
