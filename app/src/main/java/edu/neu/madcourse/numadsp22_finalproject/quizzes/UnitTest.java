package edu.neu.madcourse.numadsp22_finalproject.quizzes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import edu.neu.madcourse.numadsp22_finalproject.R;
import edu.neu.madcourse.numadsp22_finalproject.TestActivity;
import edu.neu.madcourse.numadsp22_finalproject.Util;

public class UnitTest extends AppCompatActivity {

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
    String unit_test_id;
    int bankListCount = 0;
    Bank[] bankList;
    int numCorrect;
    String finishStr = "Finish";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_test);


        // Fetch XML Components
        title = findViewById(R.id.tv_subquiz_title);
        question = findViewById(R.id.tv_subquiz_question);
        img_character = findViewById(R.id.img_character);
        btnA = findViewById(R.id.btn_subquiz_answerA);
        btnB = findViewById(R.id.btn_subquiz_answerB);
        btnC = findViewById(R.id.btn_subquiz_answerC);
        btnD = findViewById(R.id.btn_subquiz_answerD);
        btnArray = new Button[]{btnA, btnB, btnC, btnD};
        btn_nextLesson = findViewById(R.id.btn_subquiz_nextlesson);
        img_character.setImageResource(character);

        // question and answer bank
        bank = new Bank();

        // gets which unit test to render from previous intent
        Intent intent = getIntent();
        if (intent != null) {
            unit_test_id = intent.getStringExtra("UNIT_TEST_ID");
            Log.d("UNIT_TEST_ID", unit_test_id);
        } else {
            Toast.makeText(this, "Error: Couldn't fetch unit test.", Toast.LENGTH_SHORT).show();
            return;
        }

        // init list of questions and answers for unit test
        switch (unit_test_id){
            case "1":
                bankList = bank.getUT1();
                break;
            case "2":
                bankList = bank.getUT2();
                break;
            case "3":
                bankList = bank.getUT3();
                break;
            case "4":
                bankList = bank.getUT4();
                break;
            case "5":
                bankList = bank.getUT5();
                break;
            default:
                Toast.makeText(getApplicationContext(), "Error: Could not retrieve Unit Test ID.", Toast.LENGTH_SHORT).show();
                return;
        }

        setQnA(bankList[bankListCount]);

    }

    public void clearPreviousAnswer() {
        for (Button btn : btnArray) {
            // reset colors of buttons to neutral (not green or red)
            btn.setBackgroundColor(getResources().getColor(R.color.yellow3));

            // reset listeners on buttons -- after click gets null'ed to prevent double counting correct answers
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickGetQuizAnswer(view);
                }
            });
        }
    }


    public void setQnA(Bank bank){
        clearPreviousAnswer();

        question.setText(bank.question);
        btnA.setText(bank.mcA);
        btnB.setText(bank.mcB);
        btnC.setText(bank.mcC);
        btnD.setText(bank.mcD);
        title.setText(bank.title);
        img_character.setImageResource(bank.character);


        switch (bank.answer) {
            case "A":
                correctAnswerId = id_A;
                break;
            case "B":
                correctAnswerId = id_B;
                break;
            case "C":
                correctAnswerId = id_C;
                break;
            case "D":
                correctAnswerId = id_D;
                break;
            default:
                correctAnswerId = 0; // error checking
        }

        // on last question set btn to say 'Finish'
        if (bankListCount == (bankList.length-1)){
            btn_nextLesson.setText(finishStr);
        }

    }


    /**
     * onSaveInstance State - Android save instance before it is destroyed
     * (e.g. because of screen rotation)
     *
     * @param outState export information out of this state
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(KEY_CORRECT_ANSWER_ID, correctAnswerId);
        super.onSaveInstanceState(outState);
    }

    public void onClickGetQuizAnswer(View view) {

        if (view.getId() == correctAnswerId){
            numCorrect++;
        }

        if (correctAnswerId == 0) {
            Toast.makeText(getApplicationContext(), "Error occurred, couldn't fetch the correct answer.", Toast.LENGTH_SHORT).show();
            return;
        }
        for (Button btn : btnArray) {
            btn.setBackgroundColor(getResources().getColor(R.color.redInCorrect));
            btn.setOnClickListener(null); // sets listener null, prevents double count correct answers
        }
        Button correctBtn = findViewById(correctAnswerId);
        correctBtn.setBackgroundColor(getResources().getColor(R.color.greenCorrect));
    }


    public void onClickGoToNextQuestion(View view) {
        if (btn_nextLesson.getText().equals(finishStr)){
            Intent i = new Intent(this, UnitTestResults.class);
            i.putExtra(Util.KEY_NUM_CORRECT, numCorrect);
            i.putExtra(Util.KEY_UNIT_TEST_ID, unit_test_id);
            startActivity(i);
            UnitTest.this.finish();
        }
        if (bankListCount < (bankList.length-1)) {
            bankListCount++;
            setQnA(bankList[bankListCount]);
        }
    }

}
