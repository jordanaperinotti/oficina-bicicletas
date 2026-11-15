public class Customer extends Person {

    private String cpf;
    private String address;

    public Customer(String name, String phone, String cpf, String address) {
        super(name, phone);
        this.cpf = cpf;
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public String getAddress() {
        return address;
    }
}
