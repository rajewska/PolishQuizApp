package com.rajewska.polishquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score = 0;

    public void showMyResult(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        Log.v("Main Activity", "Name: " + name);

        RadioButton question1 = findViewById(R.id.answer_1);
        RadioButton question2 = findViewById(R.id.answer_2);
        RadioButton question3 = findViewById(R.id.answer_3);
        RadioButton question4 = findViewById(R.id.answer_4);
        RadioButton question5 = findViewById(R.id.answer_5);
        RadioButton question6 = findViewById(R.id.answer_6);
        RadioButton question7 = findViewById(R.id.answer_7);
        RadioButton question8 = findViewById(R.id.answer_8);
        RadioButton question9 = findViewById(R.id.answer_9);
        RadioButton question10 = findViewById(R.id.answer_10);

        if (question1.isChecked())
            score = score + 1;
        if (question2.isChecked())
            score = score + 1;
        if (question3.isChecked())
            score = score + 1;
        if (question4.isChecked())
            score = score + 1;
        if (question5.isChecked())
            score = score + 1;
        if (question6.isChecked())
            score = score + 1;
        if (question7.isChecked())
            score = score + 1;
        if (question8.isChecked())
            score = score + 1;
        if (question9.isChecked())
            score = score + 1;
        if (question10.isChecked())
            score = score + 1;

        String scoreMessage = displayScore(name, score);

        TextView scoreSummary = (TextView) findViewById(R.id.score_display);
        scoreSummary.setText(scoreMessage);

        score = 0;


    }

    public String displayScore (String name, int score) {

        String scoreMessage;

        if (score <= 3) {
            scoreMessage = "Dear " + name + ", you got only " + score + " points." +
                    " For safety reasons don't go to " + "Poland alone. Try eating some pierogi, " +
                    "listen to disco polo and see how it feels.";
        } else if ((score >= 4) && (score < 8)) {
            scoreMessage = "Not bad, " + name + ". You got " + score + " points. " +
                    "You could probably survive in Poland for a while. Consider renting an Opel " +
                    "and exploring Mazury.";
        } else {
            scoreMessage = "Well done " + name + "! You got " + score + " points. " +
                    "Looks like you know how to get 500+ " + "and find the best deals on Olx. " +
                    "You can move back to Poland as soon as " + "they kick you out of Britain...";
        }
        return scoreMessage;

    }

}


