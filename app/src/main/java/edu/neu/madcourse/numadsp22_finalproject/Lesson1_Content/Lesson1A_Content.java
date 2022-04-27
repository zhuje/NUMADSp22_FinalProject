package edu.neu.madcourse.numadsp22_finalproject.Lesson1_Content;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.neu.madcourse.numadsp22_finalproject.LessonContentAdapter;
import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.SubLesson1;

public class Lesson1A_Content extends AppCompatActivity {
    String lessonPoints[] = {"- Form that the verb will be if you look it up in the dictionary.",
    "- Verbs introduced are in present affirmative tense",
            "- You can often tell that it is in this tense due to the -u ending on the verb.",
    "- There is no set future tense in Japanese - there is only ‘past’ and ‘non-past’ tenses.",
    "- The ‘Present Affirmative’ can be used to refer to events happening in the future.",
    "- ‘Present Affirmative’ tense is a casual way of speaking, used among friends and family."};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_acontent);

        listView = (ListView) findViewById(R.id.lessonPointsList);
        LessonContentAdapter lessonContentAdapter = new LessonContentAdapter(getApplicationContext(), lessonPoints);
        listView.setAdapter(lessonContentAdapter);

        TextView textView = (TextView) findViewById(R.id.exampleText);
        textView.setText("猫は魚を食べる (neko wa sakana wo taberu)");

        TextView textView1 = (TextView) findViewById(R.id.translationTxt);
        textView1.setText("Translation: The cat is eating fish.");
    }

    public void onClickGoToLesson_1B(View view){
        Lesson1A_Content.this.finish();
        //Intent i = new Intent(this, SubLesson1.class);
        //startActivity(i);
    }




}