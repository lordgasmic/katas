package kata;

import org.junit.After;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testAddMessagesToPersonalTimeline() {
        assertEquals(0, service.getMessages("Alice").size());

        service.addMessageToTimeline("Alice", "I love the weather today");

        assertEquals(1, service.getMessages("Alice").size());
        assertEquals("I love the weather today", service.getMessages("Alice").get(0).getMessage());
    }
}
