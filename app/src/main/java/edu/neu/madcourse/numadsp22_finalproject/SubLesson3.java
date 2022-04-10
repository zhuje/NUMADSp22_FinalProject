package edu.neu.madcourse.numadsp22_finalproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SubLesson3 extends AppCompatActivity {
    String lessonList[] = {"Lesson 3A", "Lesson 3B", "Lesson 3C", "UNIT QUIZ"};
    int lockList[] = {R.drawable.greenlock2, R.drawable.redlock2, R.drawable.redlock2,
            R.drawable.redlock2};
    String lessonOneNum[] = {"03", "03", "03", "03"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_lesson3);

        listView = (ListView) findViewById(R.id.course_list);
        SubLessonsAdapter subLessonsAdapter = new SubLessonsAdapter(getApplicationContext(), lessonList, lockList, lessonOneNum);
        listView.setAdapter(subLessonsAdapter);
    }
}