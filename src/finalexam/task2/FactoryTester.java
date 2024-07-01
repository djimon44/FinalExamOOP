package finalexam.task2;

public class FactoryTester {
    public static void main(String[] args) {
        PaperFactory factory = new PaperFactory();

        // Create some test persons
        Person p1 = new Person("Nikoloz", "Kupreishvili", "1234567890");
        Person p2 = new Person("Nino", "Beridze", "0987654321");
        Person p3 = new Person("Archil", "Balbaia", "1122334455");

        // Test adding persons
        factory.addPerson(p1);
        factory.addPerson(p2);
        factory.addPerson(p3);

        System.out.println("Initial factory state:");
        System.out.println(factory);
        System.out.println("Staff count: " + factory.getStaffCount());

        // Test deleting a person
        boolean deleted = factory.deletePerson(p2);
        System.out.println("\nDeleted Nino: " + deleted);
        System.out.println("Factory state after deletion:");
        System.out.println(factory);
        System.out.println("Staff count: " + factory.getStaffCount());

        // Test adding a duplicate person
        factory.addPerson(p1);
        System.out.println("\nFactory state after trying to add a duplicate:");
        System.out.println(factory);
        System.out.println("Staff count: " + factory.getStaffCount());

        // Test deleting a non-existent person
        Person p4 = new Person("Dimitri", "Durmishian", "5566778899");
        deleted = factory.deletePerson(p4);
        System.out.println("\nDeleted non-existent person: " + deleted);
        System.out.println("Factory state:");
        System.out.println(factory);
        System.out.println("Staff count: " + factory.getStaffCount());
    }
}