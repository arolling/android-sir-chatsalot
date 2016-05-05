package com.epicodus.sirchatsalot.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.android.multiselector.MultiSelector;
import com.bignerdranch.android.multiselector.SwappingHolder;
import com.epicodus.sirchatsalot.R;
import com.epicodus.sirchatsalot.models.User;
import com.epicodus.sirchatsalot.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/5/16.
 */
public class FirebaseUserListAdapter extends FirebaseRecyclerAdapter<FirebaseUserListAdapter.UserViewHolder, User> {
    private MultiSelector mMultiSelector = new MultiSelector();
    private ArrayList<User> mUsers;

    public FirebaseUserListAdapter(Query query, Class<User> itemClass) {
        super(query, itemClass);
    }

    @Override
    public FirebaseUserListAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_item, parent, false);
        return new UserViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(FirebaseUserListAdapter.UserViewHolder holder, int position) {
        holder.bindUser(getItem(position));
    }

    @Override
    protected void itemAdded(User item, String key, int position) {

    }

    @Override
    protected void itemChanged(User oldItem, User newItem ,String key, int position) {

    }

    @Override
    protected void itemRemoved(User item, String key, int position) {

    }

    @Override
    protected void itemMoved(User item, String key, int oldPosition, int newposition) {

    }

    public class UserViewHolder extends SwappingHolder implements View.OnClickListener {
        @Bind(R.id.userNameTextView) TextView mNameTextView;
        @Bind(R.id.userEmailTextView) TextView mUserEmailTextView;

        private Context mContext;


        public UserViewHolder(View itemView, ArrayList<User> users) {
            super(itemView, mMultiSelector);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            mUsers = users;
            itemView.setOnClickListener(this);
        }

        public void bindUser(User user) {
            mNameTextView.setText(user.getName());
            mUserEmailTextView.setText(user.getEmail());
        }

        @Override
        public void onClick(View v){
            if(!mMultiSelector.isSelectable()){
                mMultiSelector.setSelectable(true);
            }
            mMultiSelector.tapSelection(this);
            Log.d("List adapter", "Tapped " + getLayoutPosition());
        }
    }

    public List<User> getSelectedUsers(){
        List<User> tappedUsers = new ArrayList<>();

        for(int i = 0; i < mUsers.size(); i++){
            if(mMultiSelector.isSelected(i, 0)){
                User user = mUsers.get(i);
                tappedUsers.add(user);
            }
        }
        return tappedUsers;
    }
}
