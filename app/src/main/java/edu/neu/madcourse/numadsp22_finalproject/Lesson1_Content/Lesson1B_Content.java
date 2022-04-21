package edu.neu.madcourse.numadsp22_finalproject.Lesson1_Content;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.quizzes.Quiz;

public class Lesson1B_Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_bcontent);
    }

    public void onClickGoToQuiz_1B(View view){
        Intent i = new Intent(this, Quiz.class);
        String quizId = "1B";
        i.putExtra("QUIZ_ID",quizId);
        startActivity(i);
    }

}