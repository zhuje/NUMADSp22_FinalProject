package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.neu.madcourse.numadsp22_finalproject.quizzes.UnitTest;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onClickGoToSublessonQuiz(View view){
        Intent intent = new Intent(this, SublessonQuiz.class);
        startActivity(intent);
    }

    public void onClickGoToProfile2(View view){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void onClickGoToSublessonQuizTest(View view){
        Intent intent = new Intent(this, TestSublesson.class);
        startActivity(intent);
    }

    public void onClickGoToUnitTests(View view){
        Intent intent = new Intent(this, TestLesson.class);
        startActivity(intent);
    }

    public void onClickGoToMainLessonScreen(View view){
        Intent intent = new Intent(this, MainLessonsScreen.class);
        startActivity(intent);
    }






}