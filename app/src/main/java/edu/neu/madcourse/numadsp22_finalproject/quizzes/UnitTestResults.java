package edu.neu.madcourse.numadsp22_finalproject.quizzes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.TestLesson;
import edu.neu.madcourse.numadsp22_finalproject.Util;

public class UnitTestResults extends AppCompatActivity {

    int numCorrect;
    String unit_test_id;
    TextView resultScore, comment;
    int rank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_test_results);

        resultScore = findViewById(R.id.tv_results_score);
        comment = findViewById(R.id.tv_results_comment);


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

        if (numCorrect == 5){
            comment.setText("Great Job! Your rank has increased");

            switch (unit_test_id){
                case "1":
                    rank = 5;
                    break;
                case "2":
                    rank = 10;
                    break;
                case "3":
                    rank = 14;
                    break;
                case "4":
                    rank = 17;
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Error: Could not update rank because we couldn't retrieve Unit Test ID.", Toast.LENGTH_SHORT).show();
                    return;
            }

            // TODO -- user.setRank(rank)

        } else {
            comment.setText("5/5 is required to unlock to next lesson. Try again.");
        }




    }

    // TODO link too return to Lesson Screen
    public void onClickBackToLessons(View view){
        Intent i = new Intent(this, TestLesson.class);
        startActivity(i);
    }



}