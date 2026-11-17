package models;

import java.time.LocalDateTime;

public class Appointment {

    private Bicycle bicycle;
    private LocalDateTime scheduledAt;
    private String notes;

    public Appointment(Bicycle bicycle, LocalDateTime scheduledAt, String notes) {
        if (bicycle == null || scheduledAt == null) {
            throw new IllegalArgumentException("Bicicleta e data do agendamento sao obrigatorios.");
        }
        if (scheduledAt.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Agendamento nao pode ser no passado.");
        }
        this.bicycle = bicycle;
        this.scheduledAt = scheduledAt;
        this.notes = notes;
    }

    public Customer getCustomer() {
        return bicycle.getCustomer();
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public String getNotes() {
        return notes;
    }
}
