package com.epicodus.sirchatsalot.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 5/4/16.
 */
public class Conversation {
    List<String> chatters;
    List<Message> messages;

    public Conversation() {
    }

    public Conversation(List<String> participants){
        this.chatters = participants;
        this.messages = new ArrayList<>();
    }

    public List<String> getChatters() {
        return chatters;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addNewMessage(Message newMessage){
        messages.add(newMessage);
    }

}
