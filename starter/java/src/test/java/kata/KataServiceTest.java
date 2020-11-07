package kata;

import org.junit.After;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KataServiceTest {

    private KataService service;

    @BeforeEach
    public void onInit(){
        service = new KataService();
    }

    @AfterEach
    public void onTearDown() {
        service = null;
    }

    @Test
    public void testAddMessagesToTimeline() {
        assertEquals(0, service.getMessages("Alice").size());

        service.addMessageToTimeline("Alice", "I love the weather today");

        assertEquals(1, service.getMessages("Alice").size());
        assertEquals("I love the weather today", service.getMessages("Alice").get(0).getMessage());
    }

    @Test
    public void testAliceViewsBobsTimeline() {
        service.addMessageToTimeline("Bob", "Darn! We lost!");
        service.addMessageToTimeline("Bob", "Good game though");

        assertEquals(2, service.getMessages("Bob").size());
        assertEquals("Darn! We lost!", service.getMessages("Bob").get(0).getMessage());
        assertEquals("Good game though", service.getMessages("Bob").get(1).getMessage());

        // assert that the time when the first message was posted is older than the second message
        assertTrue(service.getMessages("Bob").get(0).getTime().isBefore(service.getMessages("Bob").get(1).getTime()));
    }
}
