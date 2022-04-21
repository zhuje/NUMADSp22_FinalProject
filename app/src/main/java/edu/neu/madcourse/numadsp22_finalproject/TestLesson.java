package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.neu.madcourse.numadsp22_finalproject.quizzes.UnitTest;

public class TestLesson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_lesson);
    }

    public void onClickGoToUnitTest1(View view){
        Intent i = new Intent(this, UnitTest.class);
        i.putExtra(Util.KEY_UNIT_TEST_ID,"1");
        startActivity(i);
    }

    public void onClickGoToUnitTest2(View view){
        Intent i = new Intent(this, UnitTest.class);
        i.putExtra(Util.KEY_UNIT_TEST_ID,"2");
        startActivity(i);
    }

    public void onClickGoToUnitTest3(View view){
        Intent i = new Intent(this, UnitTest.class);
        i.putExtra(Util.KEY_UNIT_TEST_ID,"3");
        startActivity(i);
    }

    public void onClickGoToUnitTest4(View view){
        Intent i = new Intent(this, UnitTest.class);
        i.putExtra(Util.KEY_UNIT_TEST_ID,"4");
        startActivity(i);
    }

    public void onClickGoToUnitTest5(View view){
        Intent i = new Intent(this, UnitTest.class);
        i.putExtra(Util.KEY_UNIT_TEST_ID,"5");
        startActivity(i);
    }
}