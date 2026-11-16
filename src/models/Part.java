package models;

public class Part {

    private String description;
    private double unitPrice;
    private int quantity;

    public Part(String description, double unitPrice, int quantity) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Descricao da peca e obrigatoria.");
        }
        if (!Double.isFinite(unitPrice) || unitPrice < 0) {
            throw new IllegalArgumentException("Preco unitario deve ser finito e nao negativo.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantidade da peca deve ser positiva.");
        }
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
