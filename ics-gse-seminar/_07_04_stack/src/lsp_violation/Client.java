package lsp_violation;

public class Client {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1); s.push(2); s.peek();
        System.out.println(s.size());

        s = new CheatStack<>();
        s.push(1); s.push(2); s.peek();
        System.out.println(s.size());
    }
}
