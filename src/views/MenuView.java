package views;

import java.util.ArrayList;
import java.util.Scanner;

import models.Bicycle;
import models.Customer;
import models.Mechanic;
import models.ServiceOrder;

public class MenuView {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Mechanic> mechanics = new ArrayList<>();
    private static ArrayList<Bicycle> bicycles = new ArrayList<>();
    private static ArrayList<ServiceOrder> serviceOrders = new ArrayList<>();

    public static void start() {
        int option;
        do {
            displayMenu();
            option = readInteger("Escolha uma opcao: ");

            switch (option) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    registerMechanic();
                    break;
                case 3:
                    registerBicycle();
                    break;
                case 4:
                    openServiceOrder();
                    break;
                case 5:
                    listCustomers();
                    break;
                case 6:
                    listMechanics();
                    break;
                case 7:
                    listBicycles();
                    break;
                case 8:
                    listServiceOrders();
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (option != 0);
    }

    private static void displayMenu() {
        System.out.println("\n=== Oficina de Bicicletas ===");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Cadastrar mecanico");
        System.out.println("3. Cadastrar bicicleta");
        System.out.println("4. Abrir ordem de servico");
        System.out.println("5. Listar clientes");
        System.out.println("6. Listar mecanicos");
        System.out.println("7. Listar bicicletas");
        System.out.println("8. Listar ordens de servico");
        System.out.println("0. Sair");
    }

    private static void registerCustomer() {
        System.out.println("\n--- Cadastro de cliente ---");
        String name = readText("Nome: ");
        String phone = readText("Telefone: ");
        String cpf = readText("CPF: ");
        String address = readText("Endereco: ");
        customers.add(new Customer(name, phone, cpf, address));
        System.out.println("Cliente cadastrado.");
    }

    private static void registerMechanic() {
        System.out.println("\n--- Cadastro de mecanico ---");
        String name = readText("Nome: ");
        String phone = readText("Telefone: ");
        String registrationNumber = readText("Matricula: ");
        double salary = readDouble("Salario: ");
        mechanics.add(new Mechanic(name, phone, registrationNumber, salary));
        System.out.println("Mecanico cadastrado.");
    }

    private static void registerBicycle() {
        if (customers.isEmpty()) {
            System.out.println("Cadastre um cliente antes de cadastrar uma bicicleta.");
            return;
        }

        System.out.println("\n--- Cadastro de bicicleta ---");
        String brand = readText("Marca: ");
        String model = readText("Modelo: ");
        String color = readText("Cor: ");
        int year = readInteger("Ano: ");
        Customer customer = selectCustomer();
        bicycles.add(new Bicycle(brand, model, color, year, customer));
        System.out.println("Bicicleta cadastrada.");
    }

    private static void openServiceOrder() {
        if (bicycles.isEmpty() || mechanics.isEmpty()) {
            System.out.println("Cadastre ao menos uma bicicleta e um mecanico antes de abrir uma ordem.");
            return;
        }

        System.out.println("\n--- Nova ordem de servico ---");
        String description = readText("Descricao do servico: ");
        Bicycle bicycle = selectBicycle();
        Mechanic mechanic = selectMechanic();
        double laborCost = readDouble("Valor da mao de obra: ");
        int orderNumber = serviceOrders.size() + 1;
        serviceOrders.add(new ServiceOrder(orderNumber, description, bicycle, mechanic, laborCost));
        System.out.println("Ordem de servico " + orderNumber + " aberta. Prazo inicial: 5 dias.");
    }

    private static Customer selectCustomer() {
        listCustomers();
        int index = readIndex("Numero do cliente: ", customers.size());
        return customers.get(index);
    }

    private static Bicycle selectBicycle() {
        listBicycles();
        int index = readIndex("Numero da bicicleta: ", bicycles.size());
        return bicycles.get(index);
    }

    private static Mechanic selectMechanic() {
        listMechanics();
        int index = readIndex("Numero do mecanico: ", mechanics.size());
        return mechanics.get(index);
    }

    private static void listCustomers() {
        System.out.println("\n--- Clientes ---");
        if (customers.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.println((i + 1) + ". " + customer.getName() + " | CPF: " + customer.getCpf() + " | Telefone: "
                    + customer.getPhone() + " | Endereco: " + customer.getAddress());
        }
    }

    private static void listMechanics() {
        System.out.println("\n--- Mecanicos ---");
        if (mechanics.isEmpty()) {
            System.out.println("Nenhum mecanico cadastrado.");
            return;
        }
        for (int i = 0; i < mechanics.size(); i++) {
            Mechanic mechanic = mechanics.get(i);
            System.out.println((i + 1) + ". " + mechanic.getName()
                    + " | Matricula: " + mechanic.getBadge());
        }
    }

    private static void listBicycles() {
        System.out.println("\n--- Bicicletas ---");
        if (bicycles.isEmpty()) {
            System.out.println("Nenhuma bicicleta cadastrada.");
            return;
        }
        for (int i = 0; i < bicycles.size(); i++) {
            Bicycle bicycle = bicycles.get(i);
            System.out.println((i + 1) + ". " + bicycle.getBrand() + " "
                    + bicycle.getModel() + " (" + bicycle.getYear() + ")"
                    + " | Cliente: " + bicycle.getCustomer().getName());
        }
    }

    private static void listServiceOrders() {
        System.out.println("\n--- Ordens de servico ---");
        if (serviceOrders.isEmpty()) {
            System.out.println("Nenhuma ordem de servico cadastrada.");
            return;
        }
        for (ServiceOrder serviceOrder : serviceOrders) {
            System.out.println("OS " + serviceOrder.getNumber()
                    + " | Status: " + serviceOrder.getStatus()
                    + " | Bicicleta: " + serviceOrder.getBicycle().getBrand()
                    + " " + serviceOrder.getBicycle().getModel()
                    + " | Mecanico: " + serviceOrder.getMechanic().getName()
                    + " | Previsao: " + serviceOrder.getEstimatedDeliveryDate()
                    + " | Total: R$ " + serviceOrder.calculateTotal());
        }
    }

    private static String readText(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static int readInteger(String message) {
        while (true) {
            String input = readText(message);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException error) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            String input = readText(message).replace(',', '.');
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException error) {
                System.out.println("Digite um valor numerico valido.");
            }
        }
    }

    private static int readIndex(String message, int count) {
        while (true) {
            int number = readInteger(message);
            if (number >= 1 && number <= count) {
                return number - 1;
            }
            System.out.println("Escolha um numero entre 1 e " + count + ".");
        }
    }
}
