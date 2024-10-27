package br.com.fiap.chat.chat;

import br.com.fiap.chat.ChatApplication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageSender {

    private final SimpMessagingTemplate messagingTemplate;
    private final RabbitTemplate rabbitTemplate;
    private final ChatMessageReceiver chatMessageReceiver;

    public ChatMessageSender(RabbitTemplate rabbitTemplate, SimpMessagingTemplate messagingTemplate, ChatMessageReceiver chatMessageReceiver) {
        this.messagingTemplate = messagingTemplate;
        this.rabbitTemplate = rabbitTemplate;
        this.chatMessageReceiver = chatMessageReceiver;
    }

    public void sendMessage(String message) {
        messagingTemplate.convertAndSend("/topic/messages", message);
        rabbitTemplate.convertAndSend("/topic/messages", message);
        chatMessageReceiver.addMessage(message);
    }
}