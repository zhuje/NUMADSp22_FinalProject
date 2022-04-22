package edu.neu.madcourse.numadsp22_finalproject.Lesson3_Content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.neu.madcourse.numadsp22_finalproject.R;

public class Lesson3A_Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_acontent);
    }

    public void onClickGoToLesson3B(View view){
        Intent intent = new Intent(this, Lesson3B_Content.class);
        startActivity(intent);
    }
}