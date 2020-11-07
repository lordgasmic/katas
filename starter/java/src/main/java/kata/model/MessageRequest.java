package kata.model;

import lombok.Data;

@Data
public class MessageRequest {
    private String username;
    private String message;
}
