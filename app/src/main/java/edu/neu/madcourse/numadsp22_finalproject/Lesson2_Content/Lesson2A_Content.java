package edu.neu.madcourse.numadsp22_finalproject.Lesson2_Content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import edu.neu.madcourse.numadsp22_finalproject.Lesson1_Content.Lesson1B_Content;
import edu.neu.madcourse.numadsp22_finalproject.Lesson1_Content.Lesson1D_Content;
import edu.neu.madcourse.numadsp22_finalproject.LessonContentAdapter;
import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.SubLesson2;

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

    public void onClickGoToLesson_2B(View view){
        Lesson2A_Content.this.finish();
        //Intent i = new Intent(this, SubLesson2.class);
        //startActivity(i);
    }



}