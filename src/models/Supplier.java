package models;

public class Supplier {

    private String name;
    private String cnpj;
    private String phone;
    private String email;

    public Supplier(String name, String cnpj, String phone, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome do fornecedor e obrigatorio.");
        }
        this.name = name;
        this.cnpj = cnpj;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
