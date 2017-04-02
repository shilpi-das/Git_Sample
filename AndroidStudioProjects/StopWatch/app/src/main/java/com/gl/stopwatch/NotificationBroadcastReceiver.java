package com.gl.stopwatch;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by shilpi.das on 23-09-2016.
 */
public class NotificationBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        //Get the ID and action from intent
        String action = intent.getAction();
        int id = intent.getIntExtra(context.getString(R.string.id), 3);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(3);
        if (action.equals(context.getString(R.string.accept_action))) {
            //TODO: launch activity
        } else if (action.equals(context.getString(R.string.decline_action))) {
            //TODO: build notification
        }

    }
}
