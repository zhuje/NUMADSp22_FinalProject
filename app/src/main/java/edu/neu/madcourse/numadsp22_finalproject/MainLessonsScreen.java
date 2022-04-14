package edu.neu.madcourse.numadsp22_finalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

public class MainLessonsScreen extends AppCompatActivity {

    private FirebaseUser authUserProfile;
    private int userRank;
    private String userUUID;
    private DatabaseReference databaseReference;
    private ValueEventListener lockListener;
    private DatabaseReference rankDatabaseReference;
    final int LOCK = R.drawable.redlock2;
    final int UNLOCK = R.drawable.greenlock2;
    private CustomBaseAdapter adapter;

    String[] lessonList = {"Lesson 1", "Lesson 2", "Lesson 3", "Lesson 4", "Lesson 5"};
    int[] lockList = {UNLOCK, LOCK, LOCK, LOCK, LOCK};

    ListView listView;

    // TESTING-PURPOSES ONLY, placeholder for rank

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Tag", "Lesson 1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lessons_screen);
        // TODO -- get user rank from db
        // set as nominal value for error checking
        Log.d("Tag", "Lesson 2");
        userRank = -1;
        authUserProfile = FirebaseAuth.getInstance().getCurrentUser();
        assert authUserProfile != null;
        userUUID = authUserProfile.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        Log.d("Tag", "Lesson 3");
        userRankListener();

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
        adapter = new CustomBaseAdapter(getApplicationContext(), lessonList, lockList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO -- replace TestActivity.class with sublesson activity
                if(position == 0){
                    rankDatabaseReference.removeEventListener(lockListener);
                    startActivity(new Intent(MainLessonsScreen.this, SubLesson1.class));
                }
                if(position == 1 && userRank >= 5 ){
                    rankDatabaseReference.removeEventListener(lockListener);
                    startActivity(new Intent(MainLessonsScreen.this, SubLesson2.class));
                }
                if(position == 2 && userRank >= 10 ){
                    rankDatabaseReference.removeEventListener(lockListener);
                    startActivity(new Intent(MainLessonsScreen.this, SubLesson3.class));
                }
                if(position == 3 && userRank >= 14 ){
                    rankDatabaseReference.removeEventListener(lockListener);
                    startActivity(new Intent(MainLessonsScreen.this, SubLesson4.class));
                }
                if(position == 4 && userRank >= 17){
                    rankDatabaseReference.removeEventListener(lockListener);
                    startActivity(new Intent(MainLessonsScreen.this, SubLesson5.class));
                }
            }
        });
    }

    public void userRankListener(){

        // pseduocode | user.child("Users").child(authUserProfile.getUID()) -> data snapshot -> rank
        rankDatabaseReference = databaseReference.child("Users").child(userUUID);
        // add listener to check for changes in values?
        lockListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User value = dataSnapshot.getValue(User.class);
                if (value != null){
                    Integer myRank = value.getRank();
                    userRank = myRank;
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
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast toast = Toast.makeText(getApplicationContext(), "Error",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        };
        rankDatabaseReference.addValueEventListener(lockListener);
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