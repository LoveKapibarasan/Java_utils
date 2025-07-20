package campus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exam {
    private Module module;
    private List<Registration> registrations = new ArrayList<>();

    public Module getModule() {
        return module;
    }

    private Set<Student> studentsWhoPassed() {
        Set<Student> result = new HashSet<>();
        for (Registration r : registrations) {
            if (r.passed()) {
                result.add(r.getStudent());
            }
        }
        return result;
    }

    public boolean register(Student s) {
        if (registrations.stream().noneMatch(r -> r.getStudent().equals(s))) {
            Registration r = new Registration(this, s);
            registrations.add(r);
            return true;
        }
        return false;
    }
}
