package edu.neu.madcourse.numadsp22_finalproject.Lesson3_Content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.neu.madcourse.numadsp22_finalproject.R;

public class Lesson3B_Content extends AppCompatActivity {
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3_bcontent);

        button1 = (Button) findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLesson3b2();
            }
        });
    }

    public void openLesson3b2(){
        Intent intent = new Intent(this, Lesson3B2_Content.class);
        startActivity(intent);
    }
}