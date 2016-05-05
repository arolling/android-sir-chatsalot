package com.epicodus.sirchatsalot.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.sirchatsalot.R;
import com.epicodus.sirchatsalot.models.Conversation;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/4/16.
 */
public class ConversationViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.chatterListTextView) TextView mChatterListTextView;
    @Bind(R.id.messageQuantityTextView) TextView mMessageQuantityTextView;
    @Bind(R.id.lastPostedTextView) TextView mLastPostedTextView;

    private Context mContext;
    private ArrayList<Conversation> mConversations = new ArrayList<>();

    public ConversationViewHolder(View itemView, ArrayList<Conversation> conversations){
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mConversations = conversations;
        //todo: set on click listener for itemview
    }

    public void bindConversation(Conversation conversation){
        mChatterListTextView.setText(android.text.TextUtils.join(", ", conversation.getChatters()));
        int messageQty = conversation.getMessages().size();
        mMessageQuantityTextView.setText("Number of messages: " + messageQty);
        mLastPostedTextView.setText(conversation.getMessages().get(messageQty - 1).showRelativeDatePosted()); //todo: this probably won't work consistently
    }
}
