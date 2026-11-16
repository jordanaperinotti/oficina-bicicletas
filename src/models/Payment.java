package models;

import java.time.LocalDate;

public class Payment {

    private double amount;
    private PaymentMethod method;
    private LocalDate paymentDate;

    public Payment(double amount, PaymentMethod method) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser positivo.");
        }
        if (method == null) {
            throw new IllegalArgumentException("Forma de pagamento e obrigatoria.");
        }
        this.amount = amount;
        this.method = method;
        this.paymentDate = LocalDate.now();
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }
}
