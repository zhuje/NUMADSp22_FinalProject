package edu.neu.madcourse.numadsp22_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Verb_List extends AppCompatActivity {

    private ArrayList<Verb> verbList = new ArrayList<>();
    private ListView viewList;
    private VerbViewAdaptor adaptor;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verb_list);
        //for bottom navigation
        bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setOnItemSelectedListener(bottomNavmethod);
        // fill in list with all needed verbs
        int suwaruPicture = R.drawable.suwaru;
        Verb suwaru = new Verb("座る", "すわる", "suwaru",
                "to sit", suwaruPicture,
                "https://d1vjc5dkcd3yh2.cloudfront.net/audio/6ab09ed3495fb3563b270b11845a1443.mp3");
        int suruPicture = R.drawable.suru;
        Verb suru = new Verb("為る", "する", "suru",
                "to do", suruPicture,
                "https://d1vjc5dkcd3yh2.cloudfront.net/audio/0adcc710c8a6968661c2afe24cf2e8c2.mp3");
        int kuruPicture = R.drawable.kuru;
        Verb kuru = new Verb("来る", "くる", "kuru",
                "to come", kuruPicture,
                "https://d1vjc5dkcd3yh2.cloudfront.net/audio/1f2e375861bdcaf6c6f59cbaaf6907b7.mp3");
        int taberuPicture = R.drawable.taberu;
        Verb taberu = new Verb("食べる", "たべる", "taberu",
                "to eat", taberuPicture,
                "https://d1vjc5dkcd3yh2.cloudfront.net/audio/c8bb8e5fc9b80a3929d71e3c2579339a.mp3");
        int kikuPicture = R.drawable.kiku;
        Verb kiku = new Verb("聞く", "きく", "kiku",
                "to listen/to ask", kikuPicture,
                "https://d1vjc5dkcd3yh2.cloudfront.net/audio/27b7d0cf25de06e0bd21b9a58c911425.mp3");
        int omouPicture = R.drawable.omou;
        Verb omou = new Verb("思う", "おもう", "omou",
                "to think", omouPicture,
                "https://d1vjc5dkcd3yh2.cloudfront.net/audio/9ccbe63146dcf494d5368f2983deb981.mp3");
        int motsuPicture = R.drawable.motsu;
        Verb motsu = new Verb("持つ", "もつ", "motsu",
                "to hold", motsuPicture,
                "https://d1vjc5dkcd3yh2.cloudfront.net/audio/7b1931178a3e68fd9451200f139d43a8.mp3");
        int yomuPicture = R.drawable.yomu;
        Verb yomu = new Verb("読む", "よむ", "yomu",
                "to read", yomuPicture,
                "https://d1vjc5dkcd3yh2.cloudfront.net/audio/f9585fdca1ef179b5388df7d783e7473.mp3");
        int tobuPicture = R.drawable.tobu;
        Verb tobu = new Verb("飛ぶ", "とぶ", "tobu",
                "to fly", tobuPicture,
                "https://d1vjc5dkcd3yh2.cloudfront.net/audio/fe1e42125aa1365c9bbe4ce2803077ee.mp3");
        int hanasuPicture = R.drawable.hanasu;
        Verb hanasu = new Verb("話す", "はなす", "hanasu",
                "to speak", hanasuPicture,
                "https://d1vjc5dkcd3yh2.cloudfront.net/audio/de933873ee105f53abf84a966f66ab32.mp3");
        int oyoguPicture = R.drawable.oyogu;
        Verb oyogu = new Verb("泳ぐ", "およぐ", "oyogu",
                "to swim", oyoguPicture,
                "https://d1vjc5dkcd3yh2.cloudfront.net/audio/4aa8a737b9559b6c896004452a0e8926.mp3");
        int shinuPicture = R.drawable.shinu;
        Verb shinu = new Verb("死ぬ", "しぬ", "shinu",
                "to die", shinuPicture,
                "https://d1vjc5dkcd3yh2.cloudfront.net/audio/6d240cf77a8ed880d067a9030c905a2e.mp3");
        // add to list
        Log.d("Tag", "Part 1");
        verbList.add(suru);
        verbList.add(kuru);
        verbList.add(taberu);
        verbList.add(suwaru);
        verbList.add(kiku);
        verbList.add(omou);
        verbList.add(motsu);
        verbList.add(yomu);
        verbList.add(tobu);
        verbList.add(hanasu);
        verbList.add(oyogu);
        verbList.add(shinu);
        Log.d("Tag", "Part 2");
        viewList = findViewById(R.id.verbList);
        Log.d("Tag", "Part 3");
        // make adaptor
        adaptor = new VerbViewAdaptor(verbList, Verb_List.this);
        Log.d("Tag", "Part 4");
        viewList.setAdapter(adaptor);
        Log.d("Tag", "Part 5");
    }
    private BottomNavigationView.OnItemSelectedListener bottomNavmethod;

    {
        bottomNavmethod = item -> {

            switch (item.getItemId()) {


                case R.id.message:
                    Intent intent1 = new Intent(Verb_List.this,
                            MainMessagingActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.profile:
                    Intent intent2 = new Intent(Verb_List.this, ProfileActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.home:
                    Intent intent3 = new Intent(Verb_List.this,
                            MainLessonsScreen.class);
                    startActivity(intent3);
                    break;
                case R.id.verb:
                    break;
                case R.id.logout:
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                    break;


            }

            return true;
        };
    }

}