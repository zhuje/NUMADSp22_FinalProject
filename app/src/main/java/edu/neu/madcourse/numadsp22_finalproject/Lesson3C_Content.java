package edu.neu.madcourse.numadsp22_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Lesson3C_Content extends AppCompatActivity {
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_ccontent);

        button1 = (Button) findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLesson3c2();
            }
        });
    }

    public void openLesson3c2(){
        Intent intent = new Intent(this, Lesson3C2_Content.class);
        startActivity(intent);
    }
}