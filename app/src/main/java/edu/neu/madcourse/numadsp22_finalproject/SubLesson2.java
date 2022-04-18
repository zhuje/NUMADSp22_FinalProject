package edu.neu.madcourse.numadsp22_finalproject;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SubLesson2 extends AppCompatActivity {
    private FirebaseUser authUserProfile;
    private String userUUID;
    private DatabaseReference databaseReference;
    private DatabaseReference rankDatabaseReference;
    private ValueEventListener lockListener;
    private int userRank;
    private SubLessonsAdapter adapter;
    final int UNLOCK = R.drawable.greenlock2;
    String lessonList[] = {"Lesson 2A", "Lesson 2B", "Lesson 2C", "Lesson 2D", "UNIT QUIZ"};
    int lockList[] = {R.drawable.greenlock2, R.drawable.redlock2, R.drawable.redlock2,
            R.drawable.redlock2, R.drawable.redlock2};
    String lessonOneNum[] = {"02", "02", "02", "02", "02"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_lesson2);
        authUserProfile = FirebaseAuth.getInstance().getCurrentUser();
        userUUID = authUserProfile.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        userRankListener();
        listView = (ListView) findViewById(R.id.course_list);
        adapter = new SubLessonsAdapter(getApplicationContext(), lessonList, lockList,
                lessonOneNum);
        listView.setAdapter(adapter);
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
                    if(userRank >= 5){
                        lockList[1] = UNLOCK;
                    }
                    if(userRank >= 2){
                        lockList[2] = UNLOCK;
                    }
                    if(userRank >= 3){
                        lockList[3] = UNLOCK;
                    }
                    if(userRank >= 4){
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
}