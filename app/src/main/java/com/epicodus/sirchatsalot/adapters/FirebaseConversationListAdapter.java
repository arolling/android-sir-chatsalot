package com.epicodus.sirchatsalot.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epicodus.sirchatsalot.R;
import com.epicodus.sirchatsalot.models.Conversation;
import com.epicodus.sirchatsalot.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

/**
 * Created by Guest on 5/4/16.
 */
public class FirebaseConversationListAdapter extends FirebaseRecyclerAdapter<ConversationViewHolder, Conversation> {
    public FirebaseConversationListAdapter(Query query, Class<Conversation> itemClass) {
        super(query, itemClass);
    }

    @Override
    public ConversationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.conversation_list_item, parent, false);
        return new ConversationViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(ConversationViewHolder holder, int position) {
        holder.bindConversation(getItem(position));
    }

    @Override
    protected void itemAdded(Conversation item, String key, int position) {

    }

    @Override
    protected void itemChanged(Conversation oldItem, Conversation newItem ,String key, int position) {

    }

    @Override
    protected void itemRemoved(Conversation item, String key, int position) {

    }

    @Override
    protected void itemMoved(Conversation item, String key, int oldPosition, int newposition) {

    }

}


