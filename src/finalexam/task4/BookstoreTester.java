package finalexam.task4;

import java.io.IOException;

public class BookstoreTester {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore("My Bookstore", "123 Book St, Reading, RG1 1AB", "GB123456789");

        Publisher p1 = new Publisher("Penguin Books", "80 Strand, London, WC2R 0RL", "GB876543210");
        Publisher p2 = new Publisher("HarperCollins", "1 London Bridge St, London, SE1 9GF", "GB987654321");
        Publisher p3 = new Publisher("Random House", "20 Vauxhall Bridge Rd, London, SW1V 2SA", "GB234567890");

        bookstore.addPublisher(p1);
        bookstore.addPublisher(p2);
        bookstore.addPublisher(p3);

        System.out.println("Initial bookstore state:");
        System.out.println(bookstore);

        try {
            bookstore.savePublishersToFile("publishers.dat");
            System.out.println("Publishers saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving publishers to file: " + e.getMessage());
        }

        bookstore = new Bookstore("My Bookstore", "123 Book St, Reading, RG1 1AB", "GB123456789");
        System.out.println("\nBookstore state after clearing:");
        System.out.println(bookstore);

        try {
            bookstore.loadPublishersFromFile("publishers.dat");
            System.out.println("Publishers loaded from file successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading publishers from file: " + e.getMessage());
        }

        System.out.println("\nBookstore state after loading:");
        System.out.println(bookstore);

        boolean removed = bookstore.removePublisher(p2);
        System.out.println("\nRemoved HarperCollins: " + removed);
        System.out.println("Bookstore state after removal:");
        System.out.println(bookstore);
    }
}