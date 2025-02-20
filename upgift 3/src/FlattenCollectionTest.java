import org.junit.Test;
// import org.junit.jupiter.api.Test;
import java.util.List;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertEquals;


/*
Flatten multidimensional collection
 */
public class FlattenCollectionTest {

    @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
        List<String> result = FlattenCollection.transform(collection);

        assertEquals(result.size(), 5);
        assertEquals(result.get(0), expected.get(0));
        assertEquals(result.get(1), expected.get(1));
        assertEquals(result.get(2), expected.get(2));
        assertEquals(result.get(3), expected.get(3));
        assertEquals(result.get(4), expected.get(4));
    }

    @Test
    public void goingDeeperShouldAlsoFlattenCollection() {
        List<List<List<String>>> collection = asList(asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third")));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
        List<String> result = FlattenCollection.goingDeeper(collection);

        assertEquals(result.size(), 5);
        assertEquals(result.get(0), expected.get(0));
        assertEquals(result.get(1), expected.get(1));
        assertEquals(result.get(2), expected.get(2));
        assertEquals(result.get(3), expected.get(3));
        assertEquals(result.get(4), expected.get(4));
    }

}