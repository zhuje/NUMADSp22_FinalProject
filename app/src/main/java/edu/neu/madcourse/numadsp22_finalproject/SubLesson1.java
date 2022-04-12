package edu.neu.madcourse.numadsp22_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

public class SubLesson1 extends AppCompatActivity {

    private FirebaseUser authUserProfile;
    private int userRank;
    private String userUUID;
    private DatabaseReference databaseReference;
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
        // set as nominal value for error checking
        userRank = -1;
        authUserProfile = FirebaseAuth.getInstance().getCurrentUser();
        userUUID = authUserProfile.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        userRankListener();
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

    public void userRankListener(){

        // pseduocode | user.child("Users").child(authUserProfile.getUID()) -> data snapshot -> rank
        DatabaseReference userRankRef = databaseReference.child("Users").child(userUUID).child("rank");
        // add listener to check for changes in values?
        userRankRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Integer value = dataSnapshot.getValue(Integer.class);
                if (value != null){
                    userRank = value;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast toast = Toast.makeText(getApplicationContext(), "Error",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });
    }

    /**
     * Used to increment the user rank when needed.
     */
    public void updateUserRank(){
        // start off by getting the value
        DatabaseReference userRankRef = databaseReference.child("Users").child(userUUID).child("rank");
        // now run transaction
        userRankRef.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData currentData) {
                // get value
                Integer userValue = currentData.getValue(Integer.class);
                // increment it
                if (userValue == null) {
                    return Transaction.abort();
                } else {
                    Integer newRank = userValue + 1;
                    currentData.setValue(newRank);
                }
                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError error, boolean committed, @Nullable DataSnapshot currentData) {

            }
        });
    }
}