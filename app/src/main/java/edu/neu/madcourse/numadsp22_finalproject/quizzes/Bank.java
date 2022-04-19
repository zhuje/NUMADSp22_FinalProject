package edu.neu.madcourse.numadsp22_finalproject.quizzes;

import edu.neu.madcourse.numadsp22_finalproject.R;


/**
 * Bank represent a bank question and answers for the Sub-Lesson Quizzes
 * and Unit Tests.
 * Lesson 1: 1B, 1C, 1D
 * Lesson 2: 2B, 2C, 2D
 * Lesson 3: 3B, 3C
 * Lesson 4: 4B,
 * Lesson 5: 5B, 5C
 */
public class Bank {

    String question, answer, mcA, mcB, mcC, mcD, title;
    int character;


    public Bank(){}



    public Bank(String question, String answer, String mcA, String mcB, String mcC, String mcD,
                String title, int character){
        this.question = question;
        this.answer = answer;
        this.mcA = mcA;
        this.mcB = mcB;
        this.mcC = mcC;
        this.mcD = mcD;
        this.title = title;
        this.character = character;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * Quiz Questions - Lesson 1
     */

    public Bank get1B(){
        String question = "今晩、レストランで晩ご飯を ____________.\n" +
                "Konban, resutoran de bangohan wo ____________.\n";
        String answer = "A";
        String mcA = "A. たべる taberu";
        String mcB = "B. たばる tabaru ";
        String mcC = "C. たぼる taboru";
        String mcD = "D. たぼり tabori";
        String title = "Quiz 1B";
        int character = R.drawable.taberu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank get1C(){
        String question = "彼はこの机に _______.\n" +
                "Kare wa kono tsukue ni _______.\n";
        String answer = "B";
        String mcA = "A. taberu";
        String mcB = "B. suwaru ";
        String mcC = "C. suru";
        String mcD = "D. kuru";
        String title = "Quiz 1C";
        int character = R.drawable.suwaru;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank get1D(){
        String question = "先生が ____.\n" +
                "Sensei ga ________.\n";
        String answer = "B";
        String mcA = "A. きる kiru";
        String mcB = "B. くる kuru ";
        String mcC = "C. ぐる guru";
        String mcD = "D. くろ kuro";
        String title = "Quiz 1D";
        int character = R.drawable.kuru;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    /**
     * Quiz Questions - Lesson 2
     */

    public Bank get2B(){
        String question = "スミスさんは先週のパーティーに _____.\n" +
                "Sumisu san wa senshuu no pa-ti- ni ______.\n";
        String answer = "D";
        String mcA = "A. くる kuru";
        String mcB = "B. くた kuta ";
        String mcC = "C. こた kota";
        String mcD = "D. きた kita";
        String title = "Quiz 2B";
        int character = R.drawable.kiku;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank get2C(){
        String question = "鳥は木の上を _________.\n" +
                "Tori wa ki no ue wo ______.\n";
        String answer = "D";
        String mcA = "A. 飛んた tonta";
        String mcB = "B. 飛いた toita ";
        String mcC = "C. 飛った totta";
        String mcD = "D. 飛んだ tonda";
        String title = "Quiz 2C";
        int character = R.drawable.tobu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank get2D(){
        String question = "プールで ______.\n" +
                "Pu-ru de ______.\n";
        String answer = "A";
        String mcA = "A. 泳いだ oyoida";
        String mcB = "B. 泳いた oyoita ";
        String mcC = "C. 泳ぐた oyoguta";
        String mcD = "D. 泳ぐ oyogu";
        String title = "Quiz 2D";
        int character = R.drawable.oyogu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    /**
     * Quiz Questions - Lesson 3
     */

    public Bank get3B(){
        String question = "今日の試験を勉強  _______.\n" +
                "Kyou no shiken wo benkyou ______.\n";
        String answer = "C";
        String mcA = "A. すない sunai";
        String mcB = "B. するない surunai ";
        String mcC = "C. しない shinai";
        String mcD = "D. しなない shinanai";
        String title = "Quiz 3B";
        int character = R.drawable.character;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank get3C(){
        String question = "彼は傘を ______。\n" +
                "Kare wa kasa wo ______.\n";
        String answer = "D";
        String mcA = "A. 持たない motanai";
        String mcB = "B. 持てない motenai";
        String mcC = "C. 持つない motsunai";
        String mcD = "D. 持とない motonai";
        String title = "Quiz 3C";
        int character = R.drawable.motsu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    /**
     * Quiz Questions - Lesson 4
     */

    public Bank get4B(){
        String question = "メールで連絡 __________ください。\n" +
                "Me-ru de renraku _________ kudasai.\n";
        String answer = "A";
        String mcA = "A. して shite";
        String mcB = "B. すって sutte";
        String mcC = "C. しって shitte";
        String mcD = "D. すて sute";
        String title = "Quiz 4B";
        int character = R.drawable.character;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    /**
     * Quiz Questions - Lesson 5
     */

    public Bank get5B(){
        String question = "その山に登ることが _______. \n" +
                "Sono yama ni noboru koto ga ______.\n";
        String answer = "A";
        String mcA = "A. できる dekiru";
        String mcB = "B. せる seru";
        String mcC = "C. だきる dakiru";
        String mcD = "D. すきる sukiru";
        String title = "Quiz 5B";
        int character = R.drawable.character;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank get5C(){
        String question = "フランス語が __________.\n" +
                "Furansugo ga __________.\n";
        String answer = "A";
        String mcA = "A. 読める yomeru";
        String mcB = "B. 読まれる yomareru";
        String mcC = "C. 読められる yomerareru";
        String mcD = "D. 読む yomu";
        String title = "Quiz 5C";
        int character = R.drawable.yomu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    /**
     * UNIT TEST 1 QUESTIONS
     */

    public Bank getUT1_1(){
        String question = "今勉強 ______.\n" +
                "ima benkyou ______.\n";
        String answer = "C";
        String mcA = "A. そる soru";
        String mcB = "B. しる shiru";
        String mcC = "C. する suru";
        String mcD = "D. さる saru";
        String title = "Unit Test 1 : Q1";
        int character = R.drawable.suru;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT1_2(){
        String question = "私は音楽を _______. \n" +
                "Watashi wa ongaku wo _______.\n";
        String answer = "A";
        String mcA = "A. きく kiku";
        String mcB = "B. くる kuru";
        String mcC = "C. きる kiru";
        String mcD = "D. かく kaku";
        String title = "Unit Test 1 : Q2";
        int character = R.drawable.kiku;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT1_3(){
        String question = "おかしい所だと ____. \n" +
                "Okashii tokoro da to ____.\n";
        String answer = "B";
        String mcA = "A. おまう Omau";
        String mcB = "B. おもう Omou";
        String mcC = "C. おもった Omotta";
        String mcD = "D. おもい omoi";
        String title = "Unit Test 1 : Q3";
        int character = R.drawable.omou;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT1_4(){
        String question = "その本を______。\n" +
                "Sono hono wo ________.\n";
        String answer = "D";
        String mcA = "A. よる yoru";
        String mcB = "B. よぬ yonu";
        String mcC = "C. よぐ yogu";
        String mcD = "D. よむ yomu";
        String title = "Unit Test 1 : Q4";
        int character = R.drawable.omou;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT1_5(){
        Bank b = get1B();
        b.setTitle("Unit Test 1 : Q5");
        return b;
    }

    /**
     * UNIT TEST 2 QUESTIONS
     */

    public Bank getUT2_1(){
        String question = "昨日彼女に連絡 ________. \n" +
                "Kinou kanojo ni renraku ________.\n";
        String answer = "A";
        String mcA = "A. した shita";
        String mcB = "B. すた suta ";
        String mcC = "C. すった sutta";
        String mcD = "D. しった shitta";
        String title = "Unit Test 2 : Q1";
        int character = R.drawable.character;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT2_2(){
        String question = "もう昼ご飯を _________.\n" +
                "Mou hirugohan wo _________.\n";
        String answer = "C";
        String mcA = "A. たべった tabetta";
        String mcB = "B. たべだ tabeda ";
        String mcC = "C. たべた tabeta";
        String mcD = "D. たべるた taberuta";
        String title = "Unit Test 2 : Q2";
        int character = R.drawable.taberu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT2_3(){
        String question = "残念ながらあのかめは ____________. \n" +
                "Zannen nagara ano kame wa ____________.\n";
        String answer = "B";
        String mcA = "A. しんた shinta";
        String mcB = "B. しんだ shinda";
        String mcC = "C. しぬた shinuta";
        String mcD = "D. しいだ shiida";
        String title = "Unit Test 2 : Q3";
        int character = R.drawable.shinu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT2_4(){
        Bank b = get2B();
        b.setTitle("Unit Test 2 : Q4");
        return b;
    }

    public Bank getUT2_5(){
        Bank b = get2C();
        b.setTitle("Unit Test 2 : Q5");
        return b;
    }


    /**
     * UNIT TEST 3 QUESTIONS
     */

    public Bank getUT3_1(){
        String question = "私の友達は __________. \n" +
                "Watashi no tomodachi wa __________.\n";
        String answer = "A";
        String mcA = "A. こなかった konakatta";
        String mcB = "B. きなかった kinakatta";
        String mcC = "C. こないた konaita";
        String mcD = "D. こなかた konakata";
        String title = "Unit Test 3 : Q1";
        int character = R.drawable.character;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT3_2(){
        String question = "教科書を ____________. \n" +
                "Kyoukasho wo ____________.\n";
        String answer = "D";
        String mcA = "A. よもなかった yomonakatta";
        String mcB = "B. よむなかった yomunakatta";
        String mcC = "C. よめなかった yomenakatta";
        String mcD = "D. よまなかった yomanakatta";
        String title = "Unit Test 3 : Q2";
        int character = R.drawable.yomu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT3_3(){
        String question = "私は彼らと ___________.\n" +
                "Watashi wa karera to ___________.\n";
        String answer = "C";
        String mcA = "A. 話せない Hanasenai";
        String mcB = "B. 話なない Hananai";
        String mcC = "C. 話さない Hanasanai";
        String mcD = "D. 話らない hanaranai";
        String title = "Unit Test 3 : Q3";
        int character = R.drawable.hanasu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT3_4(){
        String question = "学生は先生の助言を __________.\n" +
                "Gakusei wa sensei no jogen wo _________.\n";
        String answer = "B";
        String mcA = "A. よもなかった kikonakatta";
        String mcB = "B. よむなかった kikanakatta";
        String mcC = "C. よめなかった kikenakatta";
        String mcD = "D. よまなかった kikunakatta";
        String title = "Unit Test 3 : Q4";
        int character = R.drawable.kiku;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT3_5(){
        String question = "そのベンチに _________________。\n" +
                "Sono benchi ni _________________.\n";
        String answer = "B";
        String mcA = "A. 座なかった suwanakatta";
        String mcB = "B. 座らなかった suwaranakatta";
        String mcC = "C. 座りなかった suwarinakatta";
        String mcD = "D. 座ならかった suwanarakatta";
        String title = "Unit Test 3 : Q5";
        int character = R.drawable.suwaru;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    /**
     * UNIT TEST 4 QUESTIONS
     */

    public Bank getUT4_1(){
        String question = "昨日は一日中勉強 _________ いた.\n" +
                "Kinou wa ichinichijuu benkyou _________ ita.\n";
        String answer = "B";
        String mcA = "A. すって sutte";
        String mcB = "B. して shite";
        String mcC = "C. しって shitte";
        String mcD = "D. すて sute";
        String title = "Unit Test 4 : Q1";
        int character = R.drawable.character;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT4_2(){
        String question = "ここに _________ ください. \n" +
                "Koko ni _________ kudasai.\n";
        String answer = "B";
        String mcA = "A. こって kotte";
        String mcB = "B. きて kite";
        String mcC = "C. きって kitte";
        String mcD = "D. こて kotee";
        String title = "Unit Test 4 : Q2";
        int character = R.drawable.kuru;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT4_3(){
        String question = "今朝ご飯を __________ いる.\n" +
                "Ima asagohan wo __________ iru.\n";
        String answer = "B";
        String mcA = "A. 食べって tabette";
        String mcB = "B. 食べて tabete";
        String mcC = "C. 食べんて ttabente";
        String mcD = "D. 食べで tabede";
        String title = "Unit Test 4 : Q3";
        int character = R.drawable.taberu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT4_4(){
        String question = "まだ ________ いる。\n" +
                "Mada ________ iru.\n";
        String answer = "A";
        String mcA = "A. おもって omotte";
        String mcB = "B. おもて omote";
        String mcC = "C. おもいて omoite";
        String mcD = "D. おもいで omoide";
        String title = "Unit Test 4 : Q4";
        int character = R.drawable.omou;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }


    public Bank getUT4_5(){
        String question = "家でパソコンを _______ いる。\n" +
                "Ie de pasokon wo ________ iru.\n";
        String answer = "C";
        String mcA = "A. 持つて motsute";
        String mcB = "B. 持て mote";
        String mcC = "C. 持って motte";
        String mcD = "D. 持たて motate";
        String title = "Unit Test 4 : Q5";
        int character = R.drawable.motsu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    /**
     * UNIT TEST 5 QUESTIONS
     */

    public Bank getUT5_1(){
        String question = "今日は学校に __________.\n" +
                "Kyou wa gakkou ni ___________.\n";
        String answer = "C";
        String mcA = "A. これる koreru";
        String mcB = "B. ける keru";
        String mcC = "C. こられる korareru";
        String mcD = "D. きれる kireru";
        String title = "Unit Test 5 : Q1";
        int character = R.drawable.kuru;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT5_2(){
        String question = "箸でサラダを __________.\n" +
                "Hashi de sarada wo __________.\n";
        String answer = "C";
        String mcA = "A. 食べる taberu";
        String mcB = "B. 食べらる taberaru";
        String mcC = "C. 食べられる taberareru";
        String mcD = "D. 食べられらる taberareraru";
        String title = "Unit Test 5 : Q2";
        int character = R.drawable.taberu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }


    public Bank getUT5_3(){
        String question = "私は海で ____________.\n" +
                "Watashi wa umi de ____________.\n";
        String answer = "B";
        String mcA = "A. およがれる oyogareru";
        String mcB = "B. およげる oyogeru";
        String mcC = "C. およぐれる oyogureru";
        String mcD = "D. およれる oyoreru";
        String title = "Unit Test 5 : Q3";
        int character = R.drawable.oyogu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }


    public Bank getUT5_4(){
        String question = "彼女はみっつの外国語を_________。\n" +
                "Kanojo wa mittsu no gaikokugo wo ________.\n";
        String answer = "C";
        String mcA = "A. はなされる hanasareru";
        String mcB = "B. はなれる hanareru";
        String mcC = "C. はなせる hanaseru";
        String mcD = "D. はなしれる hanashireru";
        String title = "Unit Test 5 : Q5";
        int character = R.drawable.hanasu;

        return new Bank(question, answer, mcA, mcB, mcC, mcD,title,character);
    }

    public Bank getUT5_5() {
        Bank b = get5B();
        b.setTitle("Unit Test 5 : Q5");
        return b;
    }


    /**
     * Arrays of Unit Test Questions
     */

    public Bank[] getUT1(){
        return new Bank[] {getUT1_1(), getUT1_2(), getUT1_3(), getUT1_4(), getUT1_5()};
    }

    public Bank[] getUT2(){
        return new Bank[] {getUT2_1(), getUT2_2(), getUT2_3(), getUT2_4(), getUT2_5()};
    }

    public Bank[] getUT3(){
        return new Bank[] {getUT3_1(), getUT3_2(), getUT3_3(), getUT3_4(), getUT3_5()};
    }

    public Bank[] getUT4(){
        return new Bank[] {getUT4_1(), getUT4_2(), getUT4_3(), getUT4_4(), getUT4_5()};
    }

    public Bank[] getUT5(){
        return new Bank[] {getUT5_1(), getUT5_2(), getUT5_3(), getUT5_4(), getUT5_5()};
    }



}

