import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tree {
    private final int id;
    private final List<Tree> children;

    public Tree(int id) {
        this.id = id;
        children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Tree addChild(Tree token) {
        children.add(token);
        return this;
    }

    public List<Tree> getChildren() {
        return Collections.unmodifiableList(children);
    }
}
