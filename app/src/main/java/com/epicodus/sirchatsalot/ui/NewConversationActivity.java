package com.epicodus.sirchatsalot.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bignerdranch.android.multiselector.MultiSelector;
import com.epicodus.sirchatsalot.Constants;
import com.epicodus.sirchatsalot.R;
import com.epicodus.sirchatsalot.adapters.FirebaseUserListAdapter;
import com.epicodus.sirchatsalot.models.Conversation;
import com.epicodus.sirchatsalot.models.User;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewConversationActivity extends AppCompatActivity{
    @Bind(R.id.chooseChattersRecyclerView) RecyclerView mChooseChatterRecyclerView;
    @Bind(R.id.startConversationButton) Button mStartConversationButton;

    private Query mQuery;
    private Firebase mFirebaseUsersRef;
    private FirebaseUserListAdapter mAdapter;
    private SharedPreferences mSharedPreferences;
    private List<User> mSelectedUsers;
    private Firebase mFirebaseConversationsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_conversation);
        ButterKnife.bind(this);

        mFirebaseUsersRef = new Firebase(Constants.FIREBASE_URL_USERS);
        mFirebaseConversationsRef = new Firebase(Constants.FIREBASE_URL_CONVERSATIONS);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        setUpFireBaseQuery();
        setUpRecyclerView();
        mStartConversationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSelectedUsers = mAdapter.getSelectedUsers();
                Log.v("first selected user: ", mSelectedUsers.get(0).getName());
                List<String> users = new ArrayList<String>();
                String userUid = mSharedPreferences.getString(Constants.KEY_UID, null);
                users.add(userUid);

                for (User thisUser: mSelectedUsers){
                    if(!users.contains(thisUser.getUserId())){
                        users.add(thisUser.getUserId());
                    }
                }
                Conversation newConversation = new Conversation(users);
                Firebase pushRef = mFirebaseConversationsRef.push();
                final String conversationPushId = pushRef.getKey();
                newConversation.setPushId(conversationPushId);
                pushRef.setValue(newConversation);



                for(String userRef: users) {


                    final List<String> conversations = new ArrayList<String>();

                    final Firebase updatedRef = new Firebase(Constants.FIREBASE_URL_USERS).child(userRef).child(Constants.FIREBASE_PROPERTY_MYCONVERSATIONS);
                    Log.d("updatedRef", updatedRef.toString());
                    updatedRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            conversations.add(conversationPushId);
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                String convo = snapshot.getValue(String.class);
                                Log.d("CONVO", convo);
                                conversations.add(convo);
                            }
                            updatedRef.setValue(conversations);

                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });


                }

                Intent intent = new Intent(NewConversationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setUpFireBaseQuery() {
        mQuery = mFirebaseUsersRef;
    }

    private void setUpRecyclerView() {
        mAdapter = new FirebaseUserListAdapter(mQuery, User.class);
        mChooseChatterRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mChooseChatterRecyclerView.setAdapter(mAdapter);
    }

}
