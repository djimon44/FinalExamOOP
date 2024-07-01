package finalexam.task1;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String invoiceNumber;
    private String customerName;
    private List<InvoiceItem> items;
    private double totalAmount;

    public Invoice(String invoiceNumber, String customerName) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addItem(String itemName, double price, int quantity) {
        InvoiceItem item = new InvoiceItem(itemName, price, quantity);
        items.add(item);
        calculateTotal();
    }

    private void calculateTotal() {
        totalAmount = items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    public void printInvoice() {
        System.out.println("Invoice Number: " + invoiceNumber);
        System.out.println("Customer: " + customerName);
        System.out.println("Items:");
        for (InvoiceItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total Amount: $" + String.format("%.2f", totalAmount));
    }

    private static class InvoiceItem {
        private String name;
        private double price;
        private int quantity;

        public InvoiceItem(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return name + " - $" + String.format("%.2f", price) + " x " + quantity;
        }
    }
}