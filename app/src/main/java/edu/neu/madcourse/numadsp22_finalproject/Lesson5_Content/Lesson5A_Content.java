package edu.neu.madcourse.numadsp22_finalproject.Lesson5_Content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.SubLesson4;
import edu.neu.madcourse.numadsp22_finalproject.SubLesson5;

public class Lesson5A_Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5_acontent);
    }

    public void onClickGoToLesson5(View view){
        Intent i = new Intent(this, SubLesson5.class);
        startActivity(i);
    }
}