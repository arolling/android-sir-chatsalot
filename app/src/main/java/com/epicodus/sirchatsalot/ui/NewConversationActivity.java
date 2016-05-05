package com.epicodus.sirchatsalot.ui;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.sirchatsalot.Constants;
import com.epicodus.sirchatsalot.R;
import com.epicodus.sirchatsalot.adapters.FirebaseUserListAdapter;
import com.epicodus.sirchatsalot.models.User;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewConversationActivity extends AppCompatActivity {
    @Bind(R.id.chooseChattersRecyclerView) RecyclerView mChooseChatterRecyclerView;

    private Query mQuery;
    private Firebase mFirebaseUsersRef;
    private FirebaseUserListAdapter mAdapter;
    private SharedPreferences mSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_conversation);
        ButterKnife.bind(this);

        mFirebaseUsersRef = new Firebase(Constants.FIREBASE_URL_USERS);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        setUpFireBaseQuery();
        setUpRecyclerView();
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
