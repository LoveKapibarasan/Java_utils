package lsp_violation;

public class CheatStack<T> extends Stack<T> {
    @Override public T peek() { return super.pop(); }
    @Override public T pop() { return super.peek(); }
}
