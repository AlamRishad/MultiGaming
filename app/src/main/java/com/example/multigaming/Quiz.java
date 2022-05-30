package com.example.multigaming;

public class Quiz {

    public String quest[] = {
            "Garampani sanctuary is located at",
            "Grand Central Terminal, Park Avenue, New York is the worlds",
            "Entomology is the science that studies",
            "For which of the following disciplines is Nobel Prize awarded?",
            "Eritrea, which became the 182nd member of the UN in 1993, is in the continent of"
    };

    public String option[][] = {
            {"Junagarh, Gujarat","Diphu, Assam","Kohima, Nagaland","Gangtok, Sikkim"},
            {"largest railway station","highest railway station","None of the above","longest railway station"},
            {"The formation of rocks","The origin and history of technical and scientific terms","Insects","Behavior of human beings"},
            {"Physics and Chemistry","Physiology or Medicine","Literature, Peace and Economics","All of the above"},
            {"Asia", "Africa", "Europe", "Australia"}
    };

    public String Answer[] = {
            "Diphu, Assam",
            "largest railway station",
            "Insects",
            "All of the above",
            "Africa"
    };

    public String getQuestion(int a){
        String question = quest[a];
        return question;
    }

    public String optionA(int a){
        String choice = option[a][0];
        return choice;
    }

    public String optionB(int a){
        String choice = option[a][1];
        return choice;
    }

    public String optionC(int a){
        String choice = option[a][2];
        return choice;
    }

    public String optionD(int a){
        String choice = option[a][3];
        return choice;
    }

    public String getAnswer(int a){
        String answer = Answer[a];
        return answer;
    }
}

