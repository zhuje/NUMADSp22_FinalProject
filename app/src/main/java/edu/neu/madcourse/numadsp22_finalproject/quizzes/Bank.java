package edu.neu.madcourse.numadsp22_finalproject.quizzes;

import edu.neu.madcourse.numadsp22_finalproject.R;

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
        String question = "彼はこの机に_______.\n" +
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
        String question = "先生が____.\n" +
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


}

