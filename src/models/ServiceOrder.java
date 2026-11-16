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
    private ArrayList<Service> services;
    private ArrayList<Part> parts;
    private ArrayList<Payment> payments;

    public ServiceOrder(int number, String description, Bicycle bicycle, Mechanic mechanic) {
        this.number = number;
        this.description = description;
        this.bicycle = bicycle;
        this.mechanic = mechanic;
        this.status = ServiceStatus.OPEN;
        this.openingDate = LocalDate.now();
        this.estimatedDeliveryDate = openingDate.plusDays(5);
        this.services = new ArrayList<>();
        this.parts = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public void addService(Service service) {
        if (service == null) {
            throw new IllegalArgumentException("Servico nao pode ser nulo.");
        }
        services.add(service);
    }

    public void addPart(Part part) {
        if (part == null) {
            throw new IllegalArgumentException("Peca nao pode ser nula.");
        }
        parts.add(part);
    }

    public void addPayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Pagamento nao pode ser nulo.");
        }
        if (payment.getAmount() > getRemainingBalance()) {
            throw new IllegalArgumentException("Pagamento excede o saldo restante de R$ "
                    + getRemainingBalance() + ".");
        }
        payments.add(payment);
    }

    @Override
    public double calculateTotal() {
        double total = getLaborCost();
        for (Part part : parts) {
            total += part.getUnitPrice() * part.getQuantity();
        }
        return total;
    }

    public double getAmountPaid() {
        double paid = 0;
        for (Payment payment : payments) {
            paid += payment.getAmount();
        }
        return paid;
    }

    public double getRemainingBalance() {
        return calculateTotal() - getAmountPaid();
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
        double laborCost = 0;
        for (Service service : services) {
            laborCost += service.getLaborCost();
        }
        return laborCost;
    }

    public ArrayList<Service> getServices() {
        return new ArrayList<>(services);
    }

    public ArrayList<Part> getParts() {
        return new ArrayList<>(parts);
    }

    public ArrayList<Payment> getPayments() {
        return new ArrayList<>(payments);
    }
}
