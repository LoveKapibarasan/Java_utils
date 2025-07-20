package lsp_violation;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> elements = new ArrayList<>();
    public int size() { return elements.size(); }
    public T peek() { return size() == 0 ? null : elements.getLast(); }
    public T pop() { return size() == 0 ? null : elements.remove(elements.size() - 1); }
    public void push(T t) { elements.add(t); }
}
