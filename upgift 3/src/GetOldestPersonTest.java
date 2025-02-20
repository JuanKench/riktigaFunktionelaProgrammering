import java.util.List;
import static java.util.Arrays.asList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/*

Get oldest person from the collection

 */

public class GetOldestPersonTest {

    @Test
    public void getOldestPersonShouldReturnOldestPerson() {

        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        Person resultPerson = GetOldestPerson.getOldestPerson(collection);

        assertEquals(resultPerson.getAge(), 42);
        assertEquals(resultPerson.getName(), "Eva");

    }



}