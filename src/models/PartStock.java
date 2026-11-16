package models;

public class PartStock {

    private String description;
    private double unitPrice;
    private int availableQuantity;
    private Supplier supplier;

    public PartStock(String description, double unitPrice, int availableQuantity, Supplier supplier) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Descricao da peca e obrigatoria.");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Preco unitario nao pode ser negativo.");
        }
        if (availableQuantity < 0) {
            throw new IllegalArgumentException("Quantidade inicial nao pode ser negativa.");
        }
        this.description = description;
        this.unitPrice = unitPrice;
        this.availableQuantity = availableQuantity;
        this.supplier = supplier;
    }

    public void addStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantidade de entrada deve ser positiva.");
        }
        availableQuantity += quantity;
    }

    public boolean hasAvailable(int quantity) {
        return quantity > 0 && quantity <= availableQuantity;
    }

    /**
     * Removes the given quantity from stock and returns it as a Part
     * line item, ready to be added to a service order.
     */
    public Part withdraw(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantidade de saida deve ser positiva.");
        }
        if (quantity > availableQuantity) {
            throw new IllegalStateException("Estoque insuficiente para " + description
                    + ". Disponivel: " + availableQuantity + ".");
        }
        availableQuantity -= quantity;
        return new Part(description, unitPrice, quantity);
    }

    public String getDescription() {
        return description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}
