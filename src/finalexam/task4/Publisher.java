package finalexam.task4;

import java.io.Serializable;

public class Publisher implements LegalEntity, Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String address;
    private String vatNumber;

    public Publisher(String name, String address, String vatNumber) {
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

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Publisher publisher = (Publisher) obj;
        return vatNumber.equals(publisher.vatNumber);
    }

    @Override
    public int hashCode() {
        return vatNumber.hashCode();
    }
}