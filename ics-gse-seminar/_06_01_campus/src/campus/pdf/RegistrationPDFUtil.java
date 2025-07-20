package campus.pdf;

import campus.Registration;

public class RegistrationPDFUtil {
    private Registration registration;

    public RegistrationPDFUtil(Registration registration) {
        this.registration = registration;
    }

    public String toPDFLine() {
        return registration.getExam().getModule().getName() + registration.getGrade();
    }
}
