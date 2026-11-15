package models;

public class Part {

    private String description;
    private double unitPrice;
    private int quantity;

    public Part(String description, double unitPrice, int quantity) {
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
