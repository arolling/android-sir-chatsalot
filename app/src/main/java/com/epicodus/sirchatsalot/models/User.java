package com.epicodus.sirchatsalot.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 5/4/16.
 */
public class User {
    private String name;
    private String email;
    private List<String> myConversations; //ID strings
    private String userId;

    public User() {}

    public User(String name, String email, String uid) {
        this.name = name;
        this.email = email;
        this.myConversations = new ArrayList<>();
        this.userId = uid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getMyConversations() {
        return myConversations;
    }

    public void setMyConversations(List<String> myConversations) {
        this.myConversations = myConversations;
    }

    public void addNewConversation(String newConversationID){
        myConversations.add(newConversationID);
    }

    public String getUserId() { return userId; }

}
