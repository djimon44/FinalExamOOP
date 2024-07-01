package finalexam.task3;

import java.io.IOException;

public class FactoryTester {
    public static void main(String[] args) {
        PaperFactory factory = new PaperFactory();

        // Create some test persons
        Person p1 = new Person("John", "Doe", "1234567890");
        Person p2 = new Person("Jane", "Smith", "0987654321");
        Person p3 = new Person("Bob", "Johnson", "1122334455");

        // Add persons to the factory
        factory.addPerson(p1);
        factory.addPerson(p2);
        factory.addPerson(p3);

        System.out.println("Initial factory state:");
        System.out.println(factory);

        // Save staff to file
        try {
            factory.saveStaffToFile("staff.dat");
            System.out.println("Staff saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving staff to file: " + e.getMessage());
        }

        // Clear the current staff
        factory = new PaperFactory();
        System.out.println("\nFactory state after clearing:");
        System.out.println(factory);

        // Load staff from file
        try {
            factory.loadStaffFromFile("staff.dat");
            System.out.println("Staff loaded from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading staff from file: " + e.getMessage());
        }

        System.out.println("\nFactory state after loading:");
        System.out.println(factory);
    }
}