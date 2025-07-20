package campus.pdf;

import java.util.ArrayList;
import java.util.List;

public class PDF {
    private List<String> lines = new ArrayList<>();

    public void addLine(String line) {
        lines.add(line);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lines.forEach(sb::append);
        return sb.toString();
    }
}
