package com.epicodus.sirchatsalot.models;

import android.text.format.DateUtils;

/**
 * Created by Guest on 5/4/16.
 */
public class Message {
    String body;
    String senderId;
    long datePosted;

    public Message(){

    }

    public Message(String body, String senderId){
        this.body = body;
        this.senderId = senderId;
        this.datePosted = System.currentTimeMillis();
    }

    public String getBody() {
        return body;
    }

    public String getSender() {
        return senderId;
    }

    public long getDatePosted() {
        return datePosted;
    }

    public CharSequence showRelativeDatePosted(){
        return DateUtils.getRelativeTimeSpanString(datePosted);
    }
}
