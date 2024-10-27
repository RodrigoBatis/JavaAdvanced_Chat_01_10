package br.com.fiap.chat.chat;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class ChatMessageReceiver {
    private final List<String> messages = new ArrayList<>();

    public List<String> GetMessages(){
        return messages;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

}