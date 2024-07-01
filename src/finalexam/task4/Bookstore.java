package finalexam.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bookstore implements LegalEntity {
    private String name;
    private String address;
    private String vatNumber;
    private List<Publisher> publishers = new ArrayList<>();

    public Bookstore(String name, String address, String vatNumber) {
        this.name = name;
        this.address = address;
        this.vatNumber = vatNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public void addPublisher(Publisher p) {
        if (p != null && !publishers.contains(p)) {
            publishers.add(p);
        }
    }

    public boolean removePublisher(Publisher p) {
        return publishers.remove(p);
    }

    public List<Publisher> getPublishers() {
        return new ArrayList<>(publishers);
    }

    public int getPublisherCount() {
        return publishers.size();
    }

    public void savePublishersToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(publishers);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadPublishersFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            publishers = (List<Publisher>) ois.readObject();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bookstore: " + name + "\n");
        sb.append("Address: ").append(address).append("\n");
        sb.append("VAT Number: ").append(vatNumber).append("\n");
        sb.append("Publishers:\n");
        for (Publisher p : publishers) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }
}