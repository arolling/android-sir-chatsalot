package com.epicodus.sirchatsalot;


/**
 * Created by Guest on 5/4/16.
 */
public class Constants {
    public static final String FIREBASE_URL = BuildConfig.FIREBASE_ROOT_URL;
    public static final String FIREBASE_LOCATION_USERS = "users";
    public static final String FIREBASE_LOCATION_CONVERSATIONS = "conversations";
    public static final String KEY_UID = "uid";
    public static final String FIREBASE_URL_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
    public static final String FIREBASE_URL_CONVERSATIONS = FIREBASE_URL + "/" + FIREBASE_LOCATION_CONVERSATIONS;

    public static final String FIREBASE_PROPERTY_MYCONVERSATIONS = "myConversations";

    public static final String KEY_USER_EMAIL = "email";
}
