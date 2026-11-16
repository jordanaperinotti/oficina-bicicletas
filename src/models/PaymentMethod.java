package models;

public enum PaymentMethod {
    CASH("Dinheiro"),
    PIX("Pix"),
    DEBIT_CARD("Cartao de debito"),
    CREDIT_CARD("Cartao de credito");

    private String portugueseLabel;

    PaymentMethod(String portugueseLabel) {
        this.portugueseLabel = portugueseLabel;
    }

    @Override
    public String toString() {
        return portugueseLabel;
    }
}
