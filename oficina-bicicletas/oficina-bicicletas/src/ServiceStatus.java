public enum ServiceStatus {
    OPEN("Aberta"),
    IN_PROGRESS("Em andamento"),
    WAITING_FOR_PART("Aguardando peca"),
    UNDER_REVIEW_AND_TESTING("Em revisao e teste"),
    WAITING_FOR_PICKUP("Aguardando retirada"),
    COMPLETED("Finalizada");

    private String portugueseLabel;

    ServiceStatus(String portugueseLabel) {
        this.portugueseLabel = portugueseLabel;
    }

    @Override
    public String toString() {
        return portugueseLabel;
    }
}
