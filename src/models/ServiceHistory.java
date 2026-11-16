package models;

import java.util.ArrayList;

public class ServiceHistory {

    private Bicycle bicycle;
    private ArrayList<ServiceOrder> serviceOrders;

    public ServiceHistory(Bicycle bicycle) {
        this.bicycle = bicycle;
        this.serviceOrders = new ArrayList<>();
    }

    public void addServiceOrder(ServiceOrder serviceOrder) {
        if (serviceOrder.getBicycle() != bicycle) {
            throw new IllegalArgumentException("A ordem de servico pertence a outra bicicleta.");
        }
        serviceOrders.add(serviceOrder);
    }

    /**
     * Returns the mechanic from the most recent order, or null when the
     * bicycle has never been serviced. Supports the planned rule of
     * prioritizing the mechanic who previously serviced the bicycle.
     */
    public Mechanic getLastMechanic() {
        if (serviceOrders.isEmpty()) {
            return null;
        }
        return serviceOrders.get(serviceOrders.size() - 1).getMechanic();
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public ArrayList<ServiceOrder> getServiceOrders() {
        return new ArrayList<>(serviceOrders);
    }
}
