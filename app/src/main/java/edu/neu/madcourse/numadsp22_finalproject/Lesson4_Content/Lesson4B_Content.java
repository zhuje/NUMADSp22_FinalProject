package edu.neu.madcourse.numadsp22_finalproject.Lesson4_Content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.quizzes.Quiz;

public class Lesson4B_Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4_bcontent);
    }

    public void onClickGoToQuiz_4B(View view){
        Intent i = new Intent(this, Quiz.class);
        String quizId = "4B";
        i.putExtra("QUIZ_ID",quizId);
        startActivity(i);
        Lesson4B_Content.this.finish();
    }
}