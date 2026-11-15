package models;

import java.time.LocalDate;
import java.util.ArrayList;

import interfaces.Calculable;

public class ServiceOrder implements Calculable {

    private int number;
    private String description;
    private Bicycle bicycle;
    private Mechanic mechanic;
    private ServiceStatus status;
    private LocalDate openingDate;
    private LocalDate estimatedDeliveryDate;
    private double laborCost;
    private ArrayList<Part> parts;

    public ServiceOrder(int number, String description, Bicycle bicycle,
            Mechanic mechanic, double laborCost) {
        this.number = number;
        this.description = description;
        this.bicycle = bicycle;
        this.mechanic = mechanic;
        this.laborCost = laborCost;
        this.status = ServiceStatus.OPEN;
        this.openingDate = LocalDate.now();
        this.estimatedDeliveryDate = openingDate.plusDays(5);
        this.parts = new ArrayList<>();
    }

    public void addPart(Part part) {
        parts.add(part);
    }

    @Override
    public double calculateTotal() {
        double total = laborCost;
        for (Part part : parts) {
            total += part.getUnitPrice() * part.getQuantity();
        }
        return total;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public ArrayList<Part> getParts() {
        return new ArrayList<>(parts);
    }
}
