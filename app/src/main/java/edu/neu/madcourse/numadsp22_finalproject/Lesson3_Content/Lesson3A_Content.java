package edu.neu.madcourse.numadsp22_finalproject.Lesson3_Content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.neu.madcourse.numadsp22_finalproject.Lesson2_Content.Lesson2C_Content;
import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.SubLesson3;

public class Lesson3A_Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_acontent);
    }

    public void onClickGoToLesson3B(View view){
        Intent intent = new Intent(this, SubLesson3.class);
        startActivity(intent);
        Lesson3A_Content.this.finish();
    }
}