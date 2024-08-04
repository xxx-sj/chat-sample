package sample.stomp.stomp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import sample.stomp.stomp.controller.dto.MessageDto;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class StompController {

    private final SimpMessageSendingOperations messagingTemplate;

    /**
     *
     * chatting 사용자가 접속을 했어요. 그러면 전체 사용자에게 보여져야겠죠?
     * /chats/rooms/{id}
     * -> 누구누구사용자가 접속했습니다.
     */

    /**
     *
     * 사용자가 입력을 했어요 그러면 이제 채팅방에 있는 사람들에게 모두 보여줘야한다.
     * /chats/rooms/{id}
     */

    @MessageMapping("/chats/rooms/{roomId}")
    public void chat(@DestinationVariable(value = "roomId") Long roomId, MessageDto messageDto) {
        System.out.println("messageDto = " + messageDto);
        messageDto.setNow(LocalDateTime.now());

        messagingTemplate.convertAndSend("/sub/chats/rooms/" + roomId, messageDto);
    }
}
