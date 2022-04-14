package edu.neu.madcourse.numadsp22_finalproject.quizzes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.TestActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz1b extends AppCompatActivity {

    // XML
    TextView title, question;
    ImageView img_character;
    Button btnA, btnB, btnC, btnD,btn_nextLesson;
    int correctAnswerId;
    int id_A = R.id.btn_subquiz_answerA;
    int id_B = R.id.btn_subquiz_answerB;
    int id_C = R.id.btn_subquiz_answerC;
    int id_D = R.id.btn_subquiz_answerD;
    Button[] btnArray;
    Bank bank;

    // logic dependent
    String lessonTitle = "Quiz 1B";
    String correctAnswerStr = "B";
    Class nextLesson = TestActivity.class;
    private static final String KEY_CORRECT_ANSWER_ID = "KEY_CORRECT_ANSWER_ID";
    int character = R.drawable.taberu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1b);

        // Fetch XML Components
        title = findViewById(R.id.tv_subquiz_title);
        question = findViewById(R.id.tv_subquiz_question);
        img_character = findViewById(R.id.img_character);
        btnA = findViewById(R.id.btn_subquiz_answerA);
        btnB = findViewById(R.id.btn_subquiz_answerB);
        btnC = findViewById(R.id.btn_subquiz_answerC);
        btnD = findViewById(R.id.btn_subquiz_answerD);
        btnArray = new Button[]{btnA,btnB,btnC,btnD};
        btn_nextLesson = findViewById(R.id.btn_subquiz_nextlesson);

        Intent intent = getIntent();
        if(intent != null){
            String quiz_id = intent.getStringExtra("QUIZ_ID");
            Log.d("QUIZ_ID : " , quiz_id);
        }
        else{
            Toast.makeText(this, "Error: Couldn't fetch quiz.", Toast.LENGTH_SHORT).show();
            return;
        }


        // Set XML Components
        img_character.setImageResource(character);

        // On Rotation -- Re-render Saved State
        renderSavedInstance(savedInstanceState);

        bank = new Bank();
        bank  = bank.get1D();


        Log.d("Gouda", bank.question);
        Log.d("Gouda", bank.answer);
        Log.d("Gouda", bank.mcA);
        Log.d("Gouda", bank.mcB);
        Log.d("Gouda", bank.mcC);
        Log.d("Gouda", bank.mcD);

        question.setText( bank.question);
        btnA.setText(bank.mcA);
        btnB.setText(bank.mcB);
        btnC.setText(bank.mcC);
        btnD.setText(bank.mcD);
        title.setText(bank.title);
        img_character.setImageResource(bank.character);


        switch (bank.answer) {
            case "A":
                correctAnswerId =  id_A;
                break;
            case "B":
                correctAnswerId =  id_B;
                break;
            case "C":
                correctAnswerId =  id_C;
                break;
            case "D":
                correctAnswerId =  id_D;
                break;
            default:
                correctAnswerId = 0; // error checking
        }





    }

    /**
     * onSaveInstance State - Android save instance before it is destroyed
     * (e.g. because of screen rotation)
     * @param outState export information out of this state
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(KEY_CORRECT_ANSWER_ID, correctAnswerId);
        super.onSaveInstanceState(outState);
    }


    private void renderSavedInstance(Bundle savedInstanceState) {
        boolean isThereASavedState = savedInstanceState != null && savedInstanceState.containsKey(KEY_CORRECT_ANSWER_ID);

        // re-render from save state
        if (isThereASavedState) {
           correctAnswerId = savedInstanceState.getInt(KEY_CORRECT_ANSWER_ID);
            if (correctAnswerId == 0 ){
                Toast.makeText(getApplicationContext(), "Error occurred, couldn't fetch the correct answer.", Toast.LENGTH_SHORT).show();
                return;
            }
            for (Button btn : btnArray){
                btn.setBackgroundColor(getResources().getColor(R.color.redInCorrect));
            }
            Button correctBtn = findViewById(correctAnswerId);
            correctBtn.setBackgroundColor(getResources().getColor(R.color.greenCorrect));
        }
    }


    public void onClickGetQuizAnswer(View view){
        if (correctAnswerId == 0 ){
            Toast.makeText(getApplicationContext(), "Error occurred, couldn't fetch the correct answer.", Toast.LENGTH_SHORT).show();
            return;
        }
        for (Button btn : btnArray){
            btn.setBackgroundColor(getResources().getColor(R.color.redInCorrect));
        }
        Button correctBtn = findViewById(correctAnswerId);
        correctBtn.setBackgroundColor(getResources().getColor(R.color.greenCorrect));
    }


    public void onClickGoToNextLesson(View view){
        // DB needs to hold name of next lesson in each quiz
        Intent intent = new Intent(this, nextLesson );
        startActivity(intent);
    }


}