package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.neu.madcourse.numadsp22_finalproject.quizzes.Quiz;

public class TestSublesson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sublesson);
    }

    public void onClickToGoQuiz(View view){
        Intent i = new Intent(this, Quiz.class);
        String quizId = "5C";
        i.putExtra("QUIZ_ID",quizId);
        startActivity(i);
    }
}