package edu.neu.madcourse.numadsp22_finalproject.Lesson2_Content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.quizzes.Quiz;

public class Lesson2B_Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_bcontent);
    }

    public void onClickGoToQuiz_2B(View view){
        Intent i = new Intent(this, Quiz.class);
        String quizId = "2B";
        i.putExtra("QUIZ_ID",quizId);
        startActivity(i);
    }



}