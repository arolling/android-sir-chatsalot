package com.epicodus.sirchatsalot.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 5/4/16.
 */
public class Conversation {
    List<String> chatters; // chatter uids
    List<Message> messages;
    private String pushId;

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

    public String getPushId() { return pushId; }

    public void setPushId(String pushId) { this.pushId = pushId; }
}
