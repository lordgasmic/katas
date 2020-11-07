package kata.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MessageDetail {

    private String message;
    private LocalDateTime time;
    private String user;
}
