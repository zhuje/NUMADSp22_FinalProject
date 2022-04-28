package edu.neu.madcourse.numadsp22_finalproject.quizzes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import edu.neu.madcourse.numadsp22_finalproject.MainLessonsScreen;
import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.TestLesson;
import edu.neu.madcourse.numadsp22_finalproject.Util;

public class UnitTestResults extends AppCompatActivity {

    // xml
    int numCorrect;
    String unit_test_id;
    TextView resultScore, comment;
    int newRank;

    // database
    FirebaseUser authUserProfile;
    DatabaseReference databaseReference;
    DatabaseReference userRankReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_test_results);

        // db
        authUserProfile = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        userRankReference = databaseReference.child("Users").child(authUserProfile.getUid()).child("rank");

        // xml
        resultScore = findViewById(R.id.tv_results_score);
        comment = findViewById(R.id.tv_results_comment);

        // get information from previous activity
        Intent intent = getIntent();
        if (intent != null) {
            numCorrect = intent.getIntExtra(Util.KEY_NUM_CORRECT,0);
            unit_test_id = intent.getStringExtra(Util.KEY_UNIT_TEST_ID);
            Log.d(Util.KEY_NUM_CORRECT, String.valueOf(numCorrect));
        } else {
            Toast.makeText(this, "Error: Couldn't fetch unit test.", Toast.LENGTH_SHORT).show();
            return;
        }

        resultScore.setText(String.valueOf(numCorrect) + "/5");

        // if user gets all questions correct increase
        // determine new rank
        if (numCorrect == 5){

            comment.setText("Great Job! The next level is unlocked.");
            switch (unit_test_id){
                case "1":
                    newRank = 5;
                    break;
                case "2":
                    newRank = 10;
                    break;
                case "3":
                    newRank = 14;
                    break;
                case "4":
                    newRank = 17;
                    break;
                case "5":
                    comment.setText("Congratulations, you mastered all the lessons!");
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Error: Could not update rank because we couldn't retrieve Unit Test ID.", Toast.LENGTH_SHORT).show();
                    return;
            }

            // increase user's rank if less than newRank
            userRankReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    try {
                        Integer rank = snapshot.getValue(Integer.class);
                        if (rank != null && rank < newRank){
                            // update user rank on database
                            databaseReference.child("Users").child(authUserProfile.getUid()).child("rank").setValue(newRank)
                                    .addOnCompleteListener( taskUpdateRank -> {
                                        if (taskUpdateRank.isSuccessful() ){
                                            Toast.makeText(UnitTestResults.this, "Your rank updated to : " + String.valueOf(newRank), Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(UnitTestResults.this, "Error: Could not update your rank.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                    }
                } catch (Exception e ){
                        Toast.makeText(getApplicationContext(),"Error! Couldn't update rank", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
//
//            // update user rank on database
//            databaseReference.child("Users").child(authUserProfile.getUid()).child("rank").setValue(newRank)
//                    .addOnCompleteListener( taskUpdateRank -> {
//                        if (taskUpdateRank.isSuccessful() ){
//                            Toast.makeText(UnitTestResults.this, "Your rank updated to : " + String.valueOf(newRank), Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(UnitTestResults.this, "Error: Could not update your rank.", Toast.LENGTH_SHORT).show();
//                        }
//                    });


        } else {
            // user didn't get all the questions correct
            comment.setText("5/5 is required to unlock to next lesson. Try again.");
        }




    }

    // TODO link too return to Lesson Screen
    public void onClickBackToLessons(View view){
        Intent i = new Intent(this, MainLessonsScreen.class);
        startActivity(i);
        UnitTestResults.this.finish();
    }



}