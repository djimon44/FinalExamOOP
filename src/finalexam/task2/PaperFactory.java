package finalexam.task2;

import java.util.ArrayList;
import java.util.List;

public class PaperFactory {
    private List<Person> staff = new ArrayList<>();

    public void addPerson(Person p) {
        if (p != null && !staff.contains(p)) {
            staff.add(p);
        }
    }

    public boolean deletePerson(Person p) {
        return staff.remove(p);
    }

    public List<Person> getStaff() {
        return new ArrayList<>(staff);  // Return a copy to preserve encapsulation
    }

    public int getStaffCount() {
        return staff.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PaperFactory Staff:\n");
        for (Person p : staff) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }
}