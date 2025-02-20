import org.junit.Test;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class TestMovieList {
    MovieList movieList = new MovieList();
    @Test
    public void amountOfMoviesIn1975(){
        int expected = 2;
        assertEquals(expected, movieList.amountOfMoviesInYear(1975));
    }

    @Test
    public void getLongstMovieRunTime(){
        int expected = 3;
        assertEquals(expected, movieList.getLongestMovieRunTime());
    }

    @Test
    public void amountOfGenresFromYear(){
        int expected = 1;
        assertEquals(expected, movieList.unikGenerasFromYear(1975));
    }
    @Test
    public void listOfActorsBasedOnImdb(){
        List<String> expected =  Arrays.asList("James Sunderland", "Mary Sunderland", "Maria", "Eddie Dombrowski", "Angela Orosco");
        assertEquals(expected, movieList.actorsInHighestimbdRatedMovies());
    }
    @Test
    public void leastActorsPerMovie (){
        String expected = "Sagan om bagaren";
        assertEquals(expected, movieList.leastAmountOfActorsInMovie());
    }

    @Test
    public void actorWithMostJobs (){
        String expected = "Nicolas Cage";
        assertEquals(expected, movieList.theActorInMostMovies());
    }

    @Test
    public void amoutOfUnikTranslations (){
        int expected = 6;
        assertEquals(expected, movieList.UnikTranslations());
    }

    @Test
    public void checkIfTitlesRepeating (){
        assertTrue(movieList.repetingTitles()); // dåligt test tror jag den kollar bara om booleanen är true :c
    }

    public TestMovieList(){


    }
}
