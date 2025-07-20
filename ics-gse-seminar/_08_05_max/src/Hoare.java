public class Hoare {
    public static int max(int a, int b) {
        // P = {a > 0 && b > 0}
        if (a > b) {
            // P' = {a > 0 && b > 0 && a > b}
            int c = a;
            // P'' = {a > 0 && b > 0 && c > 0 && a > b && c > b}
            a = b;
            // P''' = {a > 0 && b > 0 && c > 0 && a > c}
            b = c;
            // P'''' = {a > 0 && b > 0 && a > c && b > a}
        } else {
            // P''''' = {a <= b}
        }
        // P'''''' = P'''' || P''''' => Q
        // Q = {b >= a}
        return b;
    }
}
