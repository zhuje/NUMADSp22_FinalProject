package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SublessonQuiz extends AppCompatActivity {

    // XML
    TextView title;
    Button btnA, btnB, btnC, btnD,btn_nextLesson;
    int correctAnswer;
    int id_A = R.id.btn_subquiz_answerA;
    int id_B = R.id.btn_subquiz_answerB;
    int id_C = R.id.btn_subquiz_answerC;
    int id_D = R.id.btn_subquiz_answerD;
    Button[] btnArray;

    // logic dependent
    String dbCorrectAnswer = "B";
    Class nextLesson = TestActivity.class;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sublesson_quiz);

        // TODO need to save state on rotate (for colored correct/incorrect answers)


        title = findViewById(R.id.tv_subquiz_title);
        btnA = findViewById(R.id.btn_subquiz_answerA);
        btnB = findViewById(R.id.btn_subquiz_answerB);
        btnC = findViewById(R.id.btn_subquiz_answerC);
        btnD = findViewById(R.id.btn_subquiz_answerD);
        btnArray = new Button[]{btnA,btnB,btnC,btnD};

        btn_nextLesson = findViewById(R.id.btn_subquiz_nextlesson);


        switch (dbCorrectAnswer) {
            case "A":
                Log.d("Pandan", "A" + " " + dbCorrectAnswer);
                correctAnswer =  id_A;
                break;
            case "B":
                Log.d("Pandan", "B" + " " + dbCorrectAnswer) ;
                correctAnswer =  id_B;
                break;
            case "C":
                Log.d("Pandan", "C" + " " + dbCorrectAnswer);
                correctAnswer =  id_C;
                break;
            case "D":
                Log.d("Pandan", "D" + " " + dbCorrectAnswer);
                correctAnswer =  id_D;
                break;
            default:
                correctAnswer = 0; // error checking
        }

    }

    public void onClickGetQuizAnswer(View view){
        if (correctAnswer == 0 ){
            Toast.makeText(getApplicationContext(), "Error occurred, couldn't fetch the correct answer.", Toast.LENGTH_SHORT).show();
            return;
        }
        for (Button btn : btnArray){
            btn.setBackgroundColor(getResources().getColor(R.color.redInCorrect));
        }
        Button correctBtn = findViewById(correctAnswer);
        correctBtn.setBackgroundColor(getResources().getColor(R.color.greenCorrect));
    }


    public void onClickGoToNextLesson(View view){
        // DB needs to hold name of next lesson in each quiz
        Intent intent = new Intent(this, nextLesson );
        startActivity(intent);
    }


}