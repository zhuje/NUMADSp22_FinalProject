package edu.neu.madcourse.numadsp22_finalproject.Lesson4_Content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.SubLesson4;
import edu.neu.madcourse.numadsp22_finalproject.quizzes.Quiz;

public class Lesson4A2_Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4_a2_content);
    }

    public void onClickGoToLesson4(View view){
        Intent i = new Intent(this, SubLesson4.class);
        startActivity(i);
    }
}