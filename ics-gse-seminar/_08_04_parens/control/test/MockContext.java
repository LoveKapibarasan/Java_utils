import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MockContext {
    static final String PRODUCE_TOKEN_STREAM = "produceTokenStream";
    static final String CONSUME_TOKEN_STREAM = "consumeTokenStream";
    static final String PRODUCE_TREE = "produceTree";
    static final String CONSUME_TREE = "consumeTree";

    private final List<String> actions;

    public MockContext() {
        this.actions = new ArrayList<>();
    }

    public void addAction(String action) {
        actions.add(action);
    }

    public List<String> getActions() {
        return Collections.unmodifiableList(actions);
    }
}
