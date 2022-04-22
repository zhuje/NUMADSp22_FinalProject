package edu.neu.madcourse.numadsp22_finalproject.Lesson3_Content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.quizzes.Quiz;

public class Lesson3C2_Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_c2_content);
    }

    public void onClickGoToQuiz_3C(View view){
        Intent i = new Intent(this, Quiz.class);
        String quizId = "3C";
        i.putExtra("QUIZ_ID",quizId);
        startActivity(i);
    }
}