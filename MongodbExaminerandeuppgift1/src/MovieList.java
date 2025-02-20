import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MovieList {
    private final List<Movie> movies = new ArrayList<>();

    public MovieList() {
        movies.add(new Movie("1", "Sagan om bagaren", 1975, Arrays.asList("fakta"), "Johan Eriksson", Arrays.asList("Nicolas Cage"), 4.9, Arrays.asList("Svenska", "Danska", "Norska", "Engelska"), 3));

        movies.add(new Movie("2", "Tysta Staden 2", 2001, Arrays.asList("Fantasi", "Skräck"), "James Sunderland", Arrays.asList("James Sunderland", "Mary Sunderland", "Maria", "Eddie Dombrowski", "Angela Orosco"), 5.0, Arrays.asList("Svenska", "Danska", "Norska", "Engelska", "Japanska", "Polska"), 2));

        movies.add(new Movie ("3", "Natt på polisstationen", 1998, Arrays.asList("Fantasi", "Skräck"), "William Birkin", Arrays.asList("William Birkin", "Leon Scor Kennedy", "Nicolas Cage"), 2.2, Arrays.asList("Svenska", "Danska", "Norska", "Engelska"), 2));

        movies.add(new Movie("4", "Sagan om bagaren", 1925, Arrays.asList("fakta"), "Johan Eriksson", Arrays.asList("Nicolas Cage", "Johan Eriksson"), 4.9, Arrays.asList("Svenska", "Danska", "Norska", "Engelska"), 2));
    }

    public int amountOfMoviesInYear(int year) {
        return (int) movies.stream().filter(w -> w.getYear() == year).count();
    }

    public int getLongestMovieRunTime(){
        return movies.stream().map(Movie::getRuntime).max(Comparator.comparing(i -> i)).get();
    }

    public int unikGenerasFromYear(int year) {
        return (int) movies.stream().filter(f -> f.getYear() == year)
                .flatMap(f -> f.getGenres().stream())
                .distinct()
                .count();
    }

    public List<String> actorsInHighestimbdRatedMovies() {
        return movies.stream().max(Comparator.comparingDouble(Movie::getImdbRating))
                .map(Movie::getCast)
                .orElse(Collections.emptyList());
    }

    public String leastAmountOfActorsInMovie(){
        return movies.stream().min(Comparator.comparingInt(f -> f.getCast().size())).map(Movie::getTitle)
                .orElse("");
    }

    public String theActorInMostMovies(){
        return movies.stream().flatMap(f ->f.getCast().stream())
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }


    public int UnikTranslations(){
        return (int) movies.stream().flatMap(f -> f.getLanguages().stream()).distinct().count();
    }

    public boolean repetingTitles(){
        return movies.stream().collect(Collectors.groupingBy(f -> f.getTitle(), Collectors.counting()))
                .values().stream()
                .anyMatch(count -> count > 1);
    }

}