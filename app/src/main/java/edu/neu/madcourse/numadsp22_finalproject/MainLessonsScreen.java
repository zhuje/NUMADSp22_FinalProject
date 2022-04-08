package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainLessonsScreen extends AppCompatActivity {

    final int LOCK = R.drawable.redlock2;
    final int UNLOCK = R.drawable.greenlock2;

    DialogBox dialogBox;

    String[] lessonList = {"Lesson 1", "Lesson 2", "Lesson 3", "Lesson 4", "Lesson 5"};
    int[] lockList = {UNLOCK, LOCK, LOCK, LOCK, LOCK};

    ListView listView;

    // TESTING-PURPOSES ONLY, placeholder for rank
    int userRank = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lessons_screen);

        dialogBox = new DialogBox(this);


        // TODO -- get user rank from db
        // pseduocode | user.child("Users").child(authUserProfile.getUID()) -> data snapshot -> rank

        if (userRank >= 5) {
            lockList[1] = UNLOCK;
        }
        if (userRank >= 10) {
            lockList[2] = UNLOCK;
        }
        if (userRank >= 14){
            lockList[3] = UNLOCK;
        }
        if (userRank >= 17){
            lockList[4] = UNLOCK;
        }

        // generate listview
        listView = findViewById(R.id.course_list);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), lessonList, lockList);
        listView.setAdapter(customBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO -- replace TestActivity.class with sublesson activity
                if(position == 0){;
                    startActivity(new Intent(MainLessonsScreen.this, TestActivity.class));
                }
                if(position == 1 && userRank >= 5 ){;
                    startActivity(new Intent(MainLessonsScreen.this, TestActivity.class));
                }
                if(position == 2 && userRank >= 10 ){;
                    startActivity(new Intent(MainLessonsScreen.this, TestActivity.class));
                }
                if(position == 3 && userRank >= 14 ){;
                    startActivity(new Intent(MainLessonsScreen.this, TestActivity.class));
                }
                if(position == 4 && userRank >= 17){;
                    startActivity(new Intent(MainLessonsScreen.this, TestActivity.class));
                }
            }
        });
    }
}