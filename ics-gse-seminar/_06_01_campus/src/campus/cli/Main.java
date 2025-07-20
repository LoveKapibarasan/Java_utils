package campus.cli;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter number");
        int action = new Scanner(System.in).nextInt();
        boolean stop = false;
        while (!stop) {
            switch (action) {
                case 1 -> enrolStudent();
                case 2 -> registerForExam();
                case 9 -> stop = true;
            }
        }
    }

    private static void enrolStudent() {
    }

    private static void registerForExam() {
    }
}
