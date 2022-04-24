package edu.neu.madcourse.numadsp22_finalproject.Lesson4_Content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.neu.madcourse.numadsp22_finalproject.R;

public class Lesson4A_Content extends AppCompatActivity {
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4_acontent);

        button1 = (Button) findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLesson4a2();
            }
        });
    }

    public void openLesson4a2(){
        Intent intent = new Intent(this, Lesson4A2_Content.class);
        startActivity(intent);
    }
}