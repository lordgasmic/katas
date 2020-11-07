package kata;

import org.aspectj.bridge.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KataService {

    private static Map<String, List<MessageDetail>> TIMELINE = new HashMap<>();

    public List<MessageDetail> getMessages(String username) {
        return TIMELINE.getOrDefault(username, new ArrayList<>());
    }

    public void addMessageToTimeline(String username, String message) {
        List<MessageDetail> messageDetails = TIMELINE.getOrDefault(username, new ArrayList<>());

        messageDetails.add(MessageDetail.builder().message(message).build());

        TIMELINE.put(username, messageDetails);
    }
}
