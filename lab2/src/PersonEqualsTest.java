import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

public class PersonEqualsTest {

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Person.class).verify();
    }
}

