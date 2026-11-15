public class Mechanic extends Person {

    private String registrationNumber;
    private double salary;

    public Mechanic(String name, String phone, String registrationNumber, double salary) {
        super(name, phone);
        this.registrationNumber = registrationNumber;
        this.salary = salary;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public double getSalary() {
        return salary;
    }
}
