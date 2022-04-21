package com.mymadapp.lessonsui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Lesson2A_Content extends AppCompatActivity {
    String lessonPoints[] = {"* Past tense indicates that actions were completed in the past.",
            "   e.g. I studied Japanese.",
            "* Present perfect tense has a number of different functions.",
            "   e.g. to express completion: “I have just done my homework,” and experience: “I have studied Japanese before.”",
            "* In English, you distinguish the two tenses by using “have.” However, " +
                    "in Japanese, we express the two tenses by using the same form.",};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2_acontent);

        listView = (ListView) findViewById(R.id.lessonPointsList2);
        LessonContentAdapter lessonContentAdapter = new LessonContentAdapter(getApplicationContext(), lessonPoints);
        listView.setAdapter(lessonContentAdapter);
    }
}