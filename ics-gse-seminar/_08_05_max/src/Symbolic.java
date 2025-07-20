public class Symbolic {
    public static int max(int a, int b, int c) {
        // x <- a
        // y <- b
        // z <- c
        if (a > b) {
            // x > y
            b = a;
        }
        if (b > c) {
            // y > z
            c = b;
        }
        return c;
    }
}
