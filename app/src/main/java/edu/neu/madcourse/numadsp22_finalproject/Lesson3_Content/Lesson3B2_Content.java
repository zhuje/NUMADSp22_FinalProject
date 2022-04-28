package edu.neu.madcourse.numadsp22_finalproject.Lesson3_Content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.quizzes.Quiz;

public class Lesson3B2_Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_b2_content);
    }

    public void onClickGoToQuiz_3B(View view){
        Intent i = new Intent(this, Quiz.class);
        String quizId = "3B";
        i.putExtra("QUIZ_ID",quizId);
        startActivity(i);
        Lesson3B2_Content.this.finish();
    }


}