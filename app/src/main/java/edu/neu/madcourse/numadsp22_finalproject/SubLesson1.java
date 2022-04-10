package edu.neu.madcourse.numadsp22_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SubLesson1 extends AppCompatActivity {
    final int LOCK = R.drawable.redlock2;
    final int UNLOCK = R.drawable.greenlock2;
    String lessonList[] = {"Lesson 1A", "Lesson 1B", "Lesson 1C", "Lesson 1D", "UNIT QUIZ"};
    int lockList[] = {R.drawable.greenlock2, R.drawable.redlock2, R.drawable.redlock2,
            R.drawable.redlock2, R.drawable.redlock2};
    String lessonOneNum[] = {"01", "01", "01", "01", "01"};

    ListView listView;

    int L1UserRank = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_lesson1);

        //MainActivity unlockLessons = new MainActivity();


        if(L1UserRank == 1){
            lockList[1] = UNLOCK;
        }
        if(L1UserRank == 2){
            lockList[2] = UNLOCK;
        }


        listView = (ListView) findViewById(R.id.course_list);
        SubLessonsAdapter subLessonsAdapter = new SubLessonsAdapter(getApplicationContext(), lessonList, lockList, lessonOneNum);
        listView.setAdapter(subLessonsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    L1UserRank++;
                    startActivity(new Intent(SubLesson1.this, TestActivity.class));
                    if(L1UserRank == 1){
                        lockList[1] = UNLOCK;
                    }
                    //start Lesson 1A
                    //unlockLessons.userRank = 1;
                    //lockList[1] = UNLOCK;

//                    startActivity(new Intent(SubLesson1.this, MainActivity.class));
//                    unlockLesson2.lockList[1] = UNLOCK;
                }
//                if(position == 1 && unlockLessons.userRank == 1){
//                    //start Lesson 2A
//                    unlockLessons.userRank = 2;
//                    lockList[2] = UNLOCK;
//                }
//                if(position == 4){
//                    startActivity(new Intent(SubLesson1.this, MainActivity.class));
//                    MainActivity unlockL2 = new MainActivity();
//                    unlockL2.lockList = new int[]{R.drawable.greenlock2, R.drawable.greenlock2, R.drawable.redlock2,
//                            R.drawable.redlock2, R.drawable.redlock2};
//
//
//                }

            }
        });
    }
}