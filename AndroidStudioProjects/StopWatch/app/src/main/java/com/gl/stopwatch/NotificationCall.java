package com.gl.stopwatch;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;


/**
 * Class to create Notification based on Type of call
 */
public class NotificationCall {
    private ContactModel mContactModel;
    private Context mContext;
    private String mType;
    private int mNotificationType;
    private int mID;
    public static final String RETURN_CALL = "Tap to return to call";
    private NotificationManager mNotificationManager;
    private NotificationCompat.Builder mBuilder;


    public NotificationCall(ContactModel contactModel, Context context) {
        this.mContactModel = contactModel;
        this.mContext = context;
        // createNotification();
    }

    /**
     * creates notification from RemoteViews
     */
    public void createNotification() {
        RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.call_notification_layout);

        //Get type from contact model
        mType = mContactModel.getmType();

        mNotificationType = getNotificationType(mType);

        mBuilder = new NotificationCompat.Builder(mContext)
                .setSmallIcon(R.drawable.group)
                .setCustomBigContentView(remoteViews);


        // create bitmap from resource
        Bitmap bm = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.group);
        //Creating circular bitmap image
        remoteViews.setImageViewBitmap(R.id.ivProfilePicture, new CircularBitmap().getCircleBitmap(bm));
        remoteViews.setTextViewText(R.id.tvNameNumber, mContactModel.getmType());

        if (mNotificationType == 1) {
            remoteViews.setTextViewText(R.id.tvDuration, RETURN_CALL);

            //TODO: set timer
            remoteViews.setTextViewText(R.id.tvTimer, "00:00:00");

            mID = 1;

            mBuilder.setOngoing(true);
            setPendingIntent();


        } else if (mNotificationType == 2) {
            remoteViews.setTextViewText(R.id.tvDuration, RETURN_CALL);

            //TODO: set call duration
            remoteViews.setTextViewText(R.id.tvTimer, "2 HRS Ago");
            mID = 2;
            mBuilder.setAutoCancel(true);
            setPendingIntent();
        } else {
            //TODO: set name or number
            remoteViews.setTextViewText(R.id.tvDuration, mContactModel.getmName());

            remoteViews.setViewVisibility(R.id.btnAccept, View.VISIBLE);

            remoteViews.setViewVisibility(R.id.btnDecline, View.VISIBLE);

            remoteViews.setViewVisibility(R.id.tvTimer, View.GONE);
            mID = 3;

            //set pending intent on Accept button and Decline Button
            remoteViews.setOnClickPendingIntent(R.id.btnAccept, getPendingSelfIntent(mContext, mContext.getString(R.string.accept_action)));

            remoteViews.setOnClickPendingIntent(R.id.btnDecline, getPendingSelfIntent(mContext, mContext.getString(R.string.decline_action)));


            mBuilder.setOngoing(true);

        }

        // Create Notification Manager
        mNotificationManager = (NotificationManager) mContext.getSystemService(mContext.NOTIFICATION_SERVICE);
        Log.i("Mid",mID+"");
        // Build Notification with Notification Manager
        mNotificationManager.notify(mID, mBuilder.build());
    }

    private int getNotificationType(String mType) {
        //TODO: change to fix strings
        if (mType.equals("OnGoing"))
            return 1;
        else if (mType.equals("Missed"))
            return 2;
        else
            return 3;
    }


    /**
     * @param context Gets the context
     * @param action sets the action of intent
     * @return PendingIntent goes to NotificationBroadcastReceiver.class
     *
     */
    private PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(action);
        intent.putExtra(context.getString(R.string.id), mID);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    /**
     * Cancel the notification
     */
    public void cancelNotification() {

        mNotificationManager.cancel(mID);
    }

    private void setPendingIntent()
    {
        //TODO: add the class which needs  to open
        // Open NotificationView Class on Notification Click
        Intent intent = new Intent();
        // Open NotificationView.java Activity
        PendingIntent pIntent = PendingIntent.getActivity(mContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(pIntent);
    }

}
