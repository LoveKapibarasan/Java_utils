package BaseClasses;

import FluentBuilder.PresentBuilder;

public abstract class Present {

    // For connection
    public static PresentBuilder builder() {
        return PresentBuilder.builder();
    }

    public void printToConsole() {
        System.out.println(getDescription());
    }

    public abstract String getDescription();
}
