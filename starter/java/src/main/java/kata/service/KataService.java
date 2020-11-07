package kata.service;

import kata.model.MessageDetail;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@Service
public class KataService {

    private static final Map<String, List<MessageDetail>> TIMELINE = new HashMap<>();
    private static final Map<String, List<String>> FOLLOWERS = new HashMap<>();

    public List<MessageDetail> getMessages(String username) {
        return TIMELINE.getOrDefault(username, new ArrayList<>());
    }

    public void addMessageToTimeline(String username, String message) {
        List<MessageDetail> messageDetails = TIMELINE.getOrDefault(username, new ArrayList<>());
        messageDetails.add(MessageDetail.builder().message(message).time(LocalDateTime.now()).user(username).build());
        TIMELINE.put(username, messageDetails);
    }

    public void addFollower(String username, String follower) {
        List<String> followers = FOLLOWERS.getOrDefault(username, new ArrayList<>());
        followers.add(follower);
        FOLLOWERS.put(username, followers);
    }

    public List<MessageDetail> viewWall(String username) {
        List<String> followers = FOLLOWERS.getOrDefault(username, new ArrayList<>());
        followers.add(username); // add self
        return followers.stream()
                        .map(this::getMessages)
                        .flatMap(Collection::stream)
                        .sorted(comparing(MessageDetail::getTime))
                        .collect(toList());
    }
}
