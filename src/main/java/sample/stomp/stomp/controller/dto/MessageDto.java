package sample.stomp.stomp.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessageDto {

    private Long entityId;
    private String name;
    private Long roomId;
    private String message;
    private LocalDateTime now;
}
