import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MovieUtils {
    public static <T extends Comparable<T>>
        T getMaxValue(List<Movie> movies, Function<Movie, T> extractor) {
            return movies.stream()
                    .map(extractor)
                    .max(Comparator.naturalOrder())
                    .orElse(null);
        }
}