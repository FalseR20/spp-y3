import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {
    @Test
    public void looseByNullRemove() throws NullPointerException {
        Throwable thrown = assertThrows(NullPointerException.class, () -> Task2.loose(null, null));
        assertEquals(thrown.getClass(), NullPointerException.class);
    }

    @Test
    public void looseSuccess() {
        assertEquals("", Task2.loose("", "hello"));
        assertEquals("hello", Task2.loose("hello", null));
        assertEquals("hello", Task2.loose("hello", ""));
        assertEquals("eo", Task2.loose("hello", "hl"));
        assertEquals("o", Task2.loose("hello", "hel"));
    }
}
