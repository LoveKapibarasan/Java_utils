package campus;

public class Registration {
    private Exam exam;
    private Student student;
    private double grade;

    public Registration(Exam exam, Student student) {
        this.exam = exam;
        this.student = student;
    }

    public Exam getExam() {
        return exam;
    }

    public Student getStudent() {
        return student;
    }

    void setStudent(Student student) {
        if (student != this.student) {
            this.student.removeRegistration(this);
            this.student = student;
            if (student != null) {
                student.addRegistration(this);
            }
        }
    }

    public double getGrade() {
        return grade;
    }

    void enterGrade(double grade) {
        this.grade = grade;
    }

    public boolean passed() {
        return 1.0 <= grade && grade <= 4.0;
    }
}
