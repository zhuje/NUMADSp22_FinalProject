package edu.neu.madcourse.numadsp22_finalproject;

import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;


public class Util {
    public static final String EMAIL = "Email";
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";

    /**
     * Helper function to onClickRegister.
     * Checks if each editText is NOT empty.
     * This is required to register a user.
     * @param editText the editText on the Register UI
     * @param dataType the dataType being entered (e.g. username, password, email)
     */
    public static boolean isInputValid(EditText editText, String dataType){
        String string = editText.getText().toString().trim();

        Log.d("Pizza", "Inside isInputValid(), string is : " + string );

        if (dataType.equals(EMAIL)  && !Patterns.EMAIL_ADDRESS.matcher(string).matches()) {
            editText.setError("Please provide a valid email address.");
            editText.requestFocus();
            return false;
        } else if (string.isEmpty()){
            editText.setError(dataType + " is required!");
            editText.requestFocus();
            return false;
        } else {
            return true;
        }
    }



}
