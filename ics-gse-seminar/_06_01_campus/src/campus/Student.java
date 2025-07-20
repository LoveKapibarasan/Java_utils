package campus;

import campus.pdf.PDF;
import campus.pdf.RegistrationPDFUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Student extends Person {
    private int matNo;
    private static int currentMatNo = 1000;
    private Date enrolled;
    private List<Registration> registrations = new ArrayList<>();

    List<Registration> getRegistrations() {
        return Collections.unmodifiableList(registrations);
    }

    void addRegistration(Registration r) {
        if (!registrations.contains(r)) {
            registrations.add(r);
            r.setStudent(this);
        }
    }

    void removeRegistration(Registration r) {
        if (registrations.contains(r)) {
            registrations.remove(r);
            r.setStudent(null);
        }
    }

    public Date getEnrolled() {
        return enrolled;
    }

    public double getGpa() {
        double gradeSum = 0.0;
        int totalCredits = 0;
        for (Registration r : registrations) {
            int ects = r.getExam().getModule().getEcts();
            if (r.passed()) {
                totalCredits += ects;
                gradeSum += ects * r.getGrade();
            }
        }
        double gpa = gradeSum / totalCredits;
        return gpa;
    }

    public PDF generateTranscript() {
        PDF pdf = new PDF();
        for (Registration r : registrations) {
            if (r.passed()) {
                RegistrationPDFUtil ru = new RegistrationPDFUtil(r);
                String line = ru.toPDFLine();
                pdf.addLine(line);
            }
        }
        return pdf;
    }

}
