package edu.neu.madcourse.numadsp22_finalproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class NoLoginDialog {
    Activity activity;
    AlertDialog dialog;

    NoLoginDialog(Activity a) {
        activity = a;
    }

    /**
     * startLoadingDialog() -- displays a loading screen.
     * Can be dismissed if you click outside the dialog box.
     */
    public void startLoadingDialog(){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(activity);
        // LayoutInflater inflater = activity.getLayoutInflater();
        alertBuilder.setMessage("You will have limited access without logging in.");
        //alertBuilder.setView(inflater.inflate(R.layout.custom_dialog,null));
        alertBuilder.setCancelable(true);
        dialog = alertBuilder.create();
        dialog.show();
    }

    /**
     * dismissDialog() -- allows the dialog box to be dismissed
     */
    public void dismissDialog(){
        dialog.dismiss();
    }

}

