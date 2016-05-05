package com.epicodus.sirchatsalot.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.epicodus.sirchatsalot.R;
import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.newConversationButton) Button mNewConversationButton;
    @Bind(R.id.myConversationsRecyclerView) RecyclerView mMyConversationsRecyclerView;

    private ValueEventListener mUserRefListener;
    private Firebase mFirebaseRef;
    private Firebase mUserRef;
    private String mUId;
    private SharedPreferences mSharedPreferenes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mNewConversationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewConversationActivity.class);
                startActivity(intent);
            }
        });
    }
}
