package com.epicodus.sirchatsalot.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 5/4/16.
 */
public class Conversation {
    List<String> chatters = new ArrayList<>(); // chatter uids
    List<Message> messages = new ArrayList<>();
    private String pushId;

    public Conversation() {
    }

    public Conversation(List<String> participants){
        this.chatters = participants;
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
