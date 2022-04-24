package edu.neu.madcourse.numadsp22_finalproject.Lesson1_Content;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import edu.neu.madcourse.numadsp22_finalproject.LessonContentAdapter;
import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.quizzes.Quiz;

public class Lesson1C_Content extends AppCompatActivity {

    String lessonPoints[] = {"1. う (u) - 思う／おもう　(omou) - to think",
            "2. く (ku) - 聞く／きく　(kiku) - to hear, to ask",
            "3. ぐ (gu) - 泳ぐ／およぐ　(oyogu) - to swim",
            "4. す (su) - 話す／はなす　(hanasu) - to speak",
            "5. つ (tsu) - 持つ／もつ　(motsu) - to have, to possess",
            "6. ぬ (nu) - 死ぬ／しぬ　(shinu) - to die", "7. ぶ (bu) - 飛ぶ／とぶ　(tobu) - to fly",
            "8. む (mu) -  読む／よむ　yomu) - to read", "9. る (ru) - 座る／すわる　(suwaru) - to sit"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_ccontent);

        listView = (ListView) findViewById(R.id.lesson1CList);
        LessonContentAdapter lessonContentAdapter = new LessonContentAdapter(getApplicationContext(), lessonPoints);
        listView.setAdapter(lessonContentAdapter);
    }

    public void onClickGoToQuiz_1C(View view){
        Intent i = new Intent(this, Quiz.class);
        String quizId = "1B";
        i.putExtra("QUIZ_ID",quizId);
        startActivity(i);
    }
}