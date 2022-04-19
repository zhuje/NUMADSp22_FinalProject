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

    public Bank get1B(){
        String question = "Do you like cheese?";
        String answer = "A";
        String mcA = "A. Yes";
        String mcB = "B. No ";
        String mcC = "C. ughhhh";
        String mcD = "D. lactose-intolerance";
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

    public Bank get3B(){
        String question = "今日の試験を勉強  _______.\n" +
                "Kyou no shiken wo benkyou ______.\n";
        String answer = "C";
        String mcA = "A. すない sunai";
        String mcB = "B. するない surunai ";
        String mcC = "C. しない shinai";
        String mcD = "D. しなない shinanai";
        String title = "Quiz 3B";
        int character = R.drawable.shinu;

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

    // TODO enter questions for UT1 to UT5
    public Bank[] getUT1(){
        return new Bank[] {get1B(), get1C(), get1D(), get1B(), get1C()};
    }

    public Bank[] getUT2(){
        return new Bank[] {get2B(), get2C(), get2D(), get2B(), get2C()};
    }



}

