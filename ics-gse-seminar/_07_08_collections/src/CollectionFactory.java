import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class CollectionFactory {
	public <T> Collection<T> createCollection(boolean ordered, boolean unique) {
		if (ordered && unique) return new LinkedHashSet<T>();
		if (!ordered && unique) return new HashSet<T>();
		return new ArrayList<T>();
	}
}
