package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainLessonsScreen extends AppCompatActivity {

    String lessonList[] = {"Lesson 1", "Lesson 2", "Lesson 3", "Lesson 4", "Lesson 5"};
    int lockList[] = {R.drawable.greenlock2, R.drawable.greenlock2, R.drawable.redlock2,
            R.drawable.redlock2, R.drawable.redlock2};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lessons_screen);
        listView = (ListView) findViewById(R.id.course_list);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), lessonList, lockList);
        listView.setAdapter(customBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                if(position == 0){
//                    startActivity(new Intent(MainLessonsScreen.this, SubLesson1.class));
//                }

//                if(position == 1 && lockList[1] == R.drawable.greenlock2){
//                    startActivity(new Intent(MainActivity.this, SubLesson2.class));
//
//                }

            }
        });
    }
}