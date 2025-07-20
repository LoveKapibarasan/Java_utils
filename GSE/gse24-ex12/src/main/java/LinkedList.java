public class LinkedList {
    private String value;
    private LinkedList next;

    public LinkedList(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public LinkedList getNext() {
        return next;
    }

    public void add(String value) {
        if (next == null) {
            next = new LinkedList(value);
        } else {
            next.add(value);
        }
    }

    public int size() {
        if (next == null) {
            return 1;
        } else {
            return 1 + next.size();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        appendValues(sb);
        sb.append("]");
        return sb.toString();
    }

    private void appendValues(StringBuilder sb) {
        sb.append(value);
        if (next != null) {
            sb.append(", ");
            next.appendValues(sb);
        }
    }
}
