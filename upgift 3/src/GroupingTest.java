import java.util.List;
import java.util.Map;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



/*
Group people by nationality
 */
public class GroupingTest {

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {

        Person sara = new Person("Sara", 4, "Norwegian");
        Person viktor = new Person("Viktor", 40, "Serbian");
        Person eva = new Person("Eva", 42, "Norwegian");
        List<Person> collection = asList(sara, eva, viktor);
        Map<String, List<Person>> result =
                Grouping.groupByNationality(collection);

        assertTrue(result.get("Norwegian").size() == 2 );
        assertTrue(result.get("Serbian").size() == 1 );
        assertTrue(result.get("Norwegian").contains(eva));
        assertTrue(result.get("Serbian").contains(viktor));
        assertTrue(result.get("Norwegian").contains(sara));

    }

}