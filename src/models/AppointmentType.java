package models;

public enum AppointmentType {
    DROP_OFF("Entrada"),
    PICKUP("Retirada");

    private String portugueseLabel;

    AppointmentType(String portugueseLabel) {
        this.portugueseLabel = portugueseLabel;
    }

    @Override
    public String toString() {
        return portugueseLabel;
    }
}
