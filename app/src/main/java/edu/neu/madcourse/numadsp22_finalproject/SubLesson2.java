package edu.neu.madcourse.numadsp22_finalproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SubLesson2 extends AppCompatActivity {
    String lessonList[] = {"Lesson 2A", "Lesson 2B", "Lesson 2C", "Lesson 2D", "UNIT QUIZ"};
    int lockList[] = {R.drawable.greenlock2, R.drawable.redlock2, R.drawable.redlock2,
            R.drawable.redlock2, R.drawable.redlock2};
    String lessonOneNum[] = {"02", "02", "02", "02", "02"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_lesson2);

        listView = (ListView) findViewById(R.id.course_list);
        SubLessonsAdapter subLessonsAdapter = new SubLessonsAdapter(getApplicationContext(), lessonList, lockList, lessonOneNum);
        listView.setAdapter(subLessonsAdapter);
    }
}