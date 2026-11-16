package models;

import java.time.LocalDateTime;

public class Appointment {

    private Bicycle bicycle;
    private AppointmentType type;
    private LocalDateTime scheduledAt;
    private String notes;

    public Appointment(Bicycle bicycle, AppointmentType type, LocalDateTime scheduledAt, String notes) {
        if (bicycle == null || type == null || scheduledAt == null) {
            throw new IllegalArgumentException("Bicicleta, tipo e data do agendamento sao obrigatorios.");
        }
        if (scheduledAt.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Agendamento nao pode ser no passado.");
        }
        this.bicycle = bicycle;
        this.type = type;
        this.scheduledAt = scheduledAt;
        this.notes = notes;
    }

    public Customer getCustomer() {
        return bicycle.getCustomer();
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public AppointmentType getType() {
        return type;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public String getNotes() {
        return notes;
    }
}
