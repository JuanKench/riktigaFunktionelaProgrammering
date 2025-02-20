import java.util.List;
import java.util.Map;
import static java.util.Arrays.asList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*

Partition adults and kids

 */

public class PartitioningTest {

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {

        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        Map<Boolean, List<Person>> result =
                Partitioning.partitionAdults(collection);

        assertTrue(result.get(true).size() == 2 );
        assertTrue(result.get(false).size() == 1 );
        assertTrue(result.get(true).contains(eva));
        assertTrue(result.get(true).contains(viktor));
        assertTrue(result.get(false).contains(sara));

    }



}