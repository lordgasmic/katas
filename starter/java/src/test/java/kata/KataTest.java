package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataTest {

    @Test
    public void testSomeKataMethod() {
        Kata subjectUnderTest = new Kata();
        assertEquals("hello, world!", subjectUnderTest.someKataMethod());
    }
}
