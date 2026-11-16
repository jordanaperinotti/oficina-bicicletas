package models;

public class Service {

    private String description;
    private double laborCost;

    public Service(String description, double laborCost) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Descricao do servico e obrigatoria.");
        }
        if (laborCost < 0) {
            throw new IllegalArgumentException("Valor da mao de obra nao pode ser negativo.");
        }
        this.description = description;
        this.laborCost = laborCost;
    }

    public String getDescription() {
        return description;
    }

    public double getLaborCost() {
        return laborCost;
    }
}
