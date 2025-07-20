import java.util.List;

public class Min {
    /**
     * Returns the minimum element in a list
     * @param list Comparable list of elements to search
     * @return the minimum element of the list.
     */
    public static <T extends Comparable<T>> T min(List<T> list) {
        if (list == null || list.isEmpty() || list.contains(null)) {
            throw new IllegalArgumentException();
        }
        return list.stream().reduce(list.getFirst(),
                (t1, t2) -> t1.compareTo(t2) < 0 ? t1 : t2);
    }
}
