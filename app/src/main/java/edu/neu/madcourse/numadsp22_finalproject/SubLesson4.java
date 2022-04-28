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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import edu.neu.madcourse.numadsp22_finalproject.Lesson2_Content.Lesson2A_Content;
import edu.neu.madcourse.numadsp22_finalproject.Lesson4_Content.Lesson4A_Content;
import edu.neu.madcourse.numadsp22_finalproject.Lesson4_Content.Lesson4B_Content;
import edu.neu.madcourse.numadsp22_finalproject.quizzes.UnitTest;

public class SubLesson4 extends AppCompatActivity {
    private FirebaseUser authUserProfile;
    private String userUUID;
    private DatabaseReference databaseReference;
    private DatabaseReference rankDatabaseReference;
    private ValueEventListener lockListener;
    private int userRank;
    private SubLessonsAdapter adapter;
    final int UNLOCK = R.drawable.greenlock2;
    String lessonList[] = {"Lesson 4A", "Lesson 4B", "UNIT QUIZ"};
    int lockList[] = {R.drawable.greenlock2, R.drawable.redlock2, R.drawable.redlock2};
    String lessonOneNum[] = {"04", "04", "04"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_lesson4);
        authUserProfile = FirebaseAuth.getInstance().getCurrentUser();
        userUUID = authUserProfile.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        userRankListener();
        listView = (ListView) findViewById(R.id.course_list);
        adapter = new SubLessonsAdapter(getApplicationContext(), lessonList, lockList, lessonOneNum);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    startActivity(new Intent(SubLesson4.this, Lesson4A_Content.class));
                    if (userRank < 15) {
                        updateUserRank();
                    }
                }
                if (position == 1 && userRank >= 15){
                    startActivity(new Intent(SubLesson4.this, Lesson4B_Content.class));
                    if (userRank < 16) {
                        updateUserRank();
                    }
                }
                if (position == 2 && userRank >=16) {
                    // TODO add unit test
                    Intent i = new Intent(SubLesson4.this, UnitTest.class);
                    i.putExtra(Util.KEY_UNIT_TEST_ID,"4");
                    startActivity(i);
//                    if (userRank < 17) {
//                        updateUserRank();
//                    }
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
                    userRank = value.getRank();
                    if(userRank >= 15){
                        lockList[1] = UNLOCK;
                    }
                    if(userRank >= 16){
                        lockList[2] = UNLOCK;
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

    /**
     * This is for the back button
     */
    @Override
    public void onBackPressed(){
        // this will override the back pressed to give the correct method way.
        rankDatabaseReference.removeEventListener(lockListener);
        finish();
        super.onBackPressed();
    }
}