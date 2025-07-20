import org.apache.commons.lang3.ArrayUtils;

public class Lettercount {
    public static int countLetter(String input, char letter) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        for (char c : input.toCharArray()) {
            if (c == letter) {
                result ++;
            }
        }
        return result;
    }

    public static int countLetter(String[] input, char letter) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        for (String s : input) {
            result += countLetter(s, letter);
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length < 2 || args[0].length() != 1) {
            System.err.println("Usage: lettercount l Hello World");
            System.exit(1);
        }
        char letter = args[0].charAt(0);
        String[] input = ArrayUtils.remove(args, 0);
        int count = countLetter(input, letter);
        System.out.println(count);
    }
}