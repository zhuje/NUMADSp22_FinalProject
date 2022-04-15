package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.neu.madcourse.numadsp22_finalproject.quizzes.Quiz;
import edu.neu.madcourse.numadsp22_finalproject.quizzes.UnitTest;

public class TestLesson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_lesson);
    }

    public void onClickGoToUnitTest(View view){
        Intent i = new Intent(this, UnitTest.class);
        i.putExtra("UNIT_TEST_ID","1");
        startActivity(i);
    }
}