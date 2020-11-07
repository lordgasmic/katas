package kata.controller;

import kata.model.FollowerRequest;
import kata.model.MessageRequest;
import kata.service.KataService;
import kata.model.MessageDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KataController {

    @Autowired
    private KataService service;

    @GetMapping("/api/v1/messages/{username}")
    public List<MessageDetail> getMessages(@PathVariable String username) {
        return service.getMessages(username);
    }

    @PutMapping("/api/v1/follower")
    public void addFollower(@RequestBody FollowerRequest request) {
        service.addFollower(request.getUsername(), request.getFollower());
    }

    @PutMapping("/api/v1/message")
    public void addMessage(@RequestBody MessageRequest request) {
        service.addMessageToTimeline(request.getUsername(), request.getMessage());
    }

    @GetMapping("/api/v1/wall/{username}")
    public List<MessageDetail> getWall(@PathVariable String username) {
        return service.viewWall(username);
    }
}
