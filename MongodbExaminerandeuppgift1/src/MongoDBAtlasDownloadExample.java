import com.mongodb.Function;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.*;
import java.util.stream.Collectors;


public class MongoDBAtlasDownloadExample {
    public MongoDBAtlasDownloadExample() {


        //Skriv in rätt url!
        String uri = "mongodb+srv://Trash:Trashy9999@cluster0.d63ek.mongodb.net/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> moviesCollection = database.getCollection("movies");

            //Get all movies from 1975
            List<Movie> movieList = new ArrayList<>();
            for (Document doc : moviesCollection.find(new Document("year", 1975))) {
                {
                    movieList.add(Movie.fromDocument(doc));
                }
            }

            //Här gör du anrop till alla dina funktioner som ska skriva ut svaren på frågorna som
            //efterfrågas i uppgiften


            long amountOfMoviesInYear = movieList.stream().filter(w -> w.getYear() == 1975).count();
            System.out.println(amountOfMoviesInYear);

            long getLongestMovieRunTime = MovieUtils.getMaxValue(movieList, Movie::getRuntime); // använder HOF
            System.out.println(getLongestMovieRunTime);

            int unikGenerasFromYear = (int) movieList.stream().filter(f -> f.getYear() == 1975).flatMap(f -> f.getGenres().stream()).distinct().count();
            System.out.println(unikGenerasFromYear);

            List<String> actorsInHighestimbdRatedMovies = movieList.stream().max(Comparator.comparingDouble(Movie::getImdbRating))
                    .map(Movie::getCast)
                    .orElse(Collections.emptyList());
            System.out.println(actorsInHighestimbdRatedMovies);

            String leastAmountOfActorsInMovie = movieList.stream().min(Comparator.comparingInt(f -> f.getCast().size())).map(Movie::getTitle).orElse("");
            System.out.println(leastAmountOfActorsInMovie);

            String theActorInMostMovies = movieList.stream().flatMap(f ->f.getCast().stream())
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);
            System.out.println(theActorInMostMovies);

            int UnikTranslations = (int) movieList.stream().flatMap(f -> f.getLanguages().stream()).distinct().count();
            System.out.println(UnikTranslations);

            boolean repetingTitles = movieList.stream().collect(Collectors.groupingBy(f -> f.getTitle(), Collectors.counting()))
                    .values().stream()
                    .anyMatch(count -> count > 1);
            System.out.println(repetingTitles);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void main(String[] args) {
        MongoDBAtlasDownloadExample m = new MongoDBAtlasDownloadExample();
    }
}

