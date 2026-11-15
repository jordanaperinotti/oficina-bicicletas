public class Mechanic extends Person {

    private String badge;
    private double salary;

    public Mechanic(String name, String phone, String badge, double salary) {
        super(name, phone);
        this.badge = badge;
        this.salary = salary;
    }

    public String getBadge() {
        return badge;
    }

    public double getSalary() {
        return salary;
    }
}
