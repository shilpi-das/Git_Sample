package com.gl.contacts.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.gl.contacts.R;
import com.gl.contacts.util.ContactModel;

import java.util.ArrayList;

/**
 * Adapter class to populate recycler view
 */
public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // The items to display in  RecyclerView
    private ArrayList<ContactModel> mAlContactModels;
    private ContactModel mContactModel;
    private static final int NORMAL_CALL = 0;
    private static final int ONGOING_CALL = 1;


    //Constructor to initialize ArrayList of ContactModels
    public ContactRecyclerViewAdapter(ArrayList<ContactModel> mAlContactModels) {
        this.mAlContactModels = mAlContactModels;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        if (viewType == NORMAL_CALL) {
            View viewNormalTypeCall = inflater.inflate(R.layout.item_contact_layout, viewGroup, false);
            viewHolder = new ViewHolderNormalTypeCall(viewNormalTypeCall);


        } else {
            View viewOnGoingTypeCall = inflater.inflate(R.layout.item_contact_ongoing_call_layout, viewGroup, false);
            viewHolder = new ViewHolderOnGoingCall(viewOnGoingTypeCall);
        }


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        mContactModel=mAlContactModels.get(position);

        if (holder.getItemViewType() == NORMAL_CALL) {
            ViewHolderNormalTypeCall viewHolderNormalTypeCall = (ViewHolderNormalTypeCall) holder;
            configureViewHolderNormalCall(viewHolderNormalTypeCall);


        } else {
            ViewHolderOnGoingCall viewHolderOnGoingCall = (ViewHolderOnGoingCall) holder;
            configureViewHolderOnGoingCall(viewHolderOnGoingCall);
        }

    }

    private void configureViewHolderOnGoingCall(ViewHolderOnGoingCall viewHolderOnGoingCall) {

        //TODO:check if name is present
        viewHolderOnGoingCall.mTvContactName.setText(mContactModel.getmName());
        //TODO:check set clock time
        viewHolderOnGoingCall.mTxtClk.setText("");

        //Todo: add method for string duration
        viewHolderOnGoingCall.mTvContactDuration.setText("");

        //Todo: Check and add image
        viewHolderOnGoingCall.mIvProfileImage.setImageResource(R.drawable.group);
    }

    private void configureViewHolderNormalCall(ViewHolderNormalTypeCall viewHolderNormalTypeCall) {
        //TODO:check if name is present
        viewHolderNormalTypeCall.mTvContactName.setText(mContactModel.getmName());
        //Todo: add method for string duration
        viewHolderNormalTypeCall.mTvContactDuration.setText("");
        //Todo: Check and add image
        viewHolderNormalTypeCall.mIvProfileImage.setImageResource(R.drawable.group);

    }

    @Override
    public int getItemCount() {
        return mAlContactModels.size();
    }


    /**
     * ViewHolderClass for Normal Call
     */
    private class ViewHolderNormalTypeCall extends RecyclerView.ViewHolder {

        private TextView mTvContactName, mTvContactDuration;
        private ImageView  mIvCallImage;
        private CircularImageView mIvProfileImage;

        public ViewHolderNormalTypeCall(View v) {
            super(v);
            mTvContactName = (TextView) v.findViewById(R.id.tvItemContactNameNumber);
            mTvContactDuration = (TextView) v.findViewById(R.id.tvItemContactDuration);
            mIvProfileImage = (CircularImageView) v.findViewById(R.id.ivItemContactProfilePicture);
            mIvCallImage = (ImageView) v.findViewById(R.id.ivItemContactCallImage);


        }
    }

    /**
     * ViewHolderClass for OnGoing Call
     */
    private class ViewHolderOnGoingCall extends RecyclerView.ViewHolder {

        private TextView mTvContactName, mTvContactDuration;
        private CircularImageView mIvProfileImage;
        private TextClock mTxtClk;

        public ViewHolderOnGoingCall(View v) {
            super(v);
            mTvContactName = (TextView) v.findViewById(R.id.tvItemOnGoingCallNameNumber);
            mTvContactDuration = (TextView) v.findViewById(R.id.tvItemOnGoingCallDuration);
            mIvProfileImage = (CircularImageView) v.findViewById(R.id.ivItemOnGoingCallProfilePicture);
            mTxtClk = (TextClock) v.findViewById(R.id.txtClktemOnGoingCall);


        }

    }
}
