package models;

public class Bicycle {

    private String brand;
    private String model;
    private String color;
    private int year;
    private Customer customer;
    private ServiceHistory serviceHistory;

    public Bicycle(String brand, String model, String color, int year, Customer customer) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.customer = customer;
        this.serviceHistory = new ServiceHistory(this);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ServiceHistory getServiceHistory() {
        return serviceHistory;
    }
}
