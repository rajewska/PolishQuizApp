package com.rajewska.polishquizapp;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* This method takes the focus out of the EditText */

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    /* This method saves the user's name and checks the answers */

    public void showMyResult(View view) {
        int score = 0;
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        if (name.equalsIgnoreCase("")) {
            Toast.makeText(this, R.string.type_name, Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton question1 = findViewById(R.id.answer_1_rb);
        RadioButton question2 = findViewById(R.id.answer_2_rb);
        RadioButton question3 = findViewById(R.id.answer_3_rb);

        CheckBox question4a = findViewById(R.id.answer_4a_cb);
        CheckBox question4b = findViewById(R.id.answer_4b_cb);
        CheckBox question4c = findViewById(R.id.answer_4c_cb);

        RadioButton question5 = findViewById(R.id.answer_5_rb);
        RadioButton question6 = findViewById(R.id.answer_6_rb);
        RadioButton question7 = findViewById(R.id.answer_7_rb);

        EditText answer8 = findViewById(R.id.answer_8_et);
        String question8 = answer8.getText().toString();

        RadioButton question9 = findViewById(R.id.answer_9_rb);
        RadioButton question10 = findViewById(R.id.answer_10_rb);

        if (question1.isChecked()) {
            score = score + 1;
        }
        if (question2.isChecked()) {
            score = score + 1;
        }
        if (question3.isChecked()) {
            score = score + 1;
        }
        if (!question4a.isChecked() && question4b.isChecked() && question4c.isChecked()) {
            score = score + 1;
        }
        if (question5.isChecked()) {
            score = score + 1;
        }
        if (question6.isChecked()) {
            score = score + 1;
        }
        if (question7.isChecked()) {
            score = score + 1;
        }
        if (question8.equalsIgnoreCase("babies")) {
            score = score + 1;
        }
        if (question9.isChecked()) {
            score = score + 1;
        }
        if (question10.isChecked()) {
            score = score + 1;
        }

        String scoreMessage = displayScore(name, score);

        TextView scoreSummary = (TextView) findViewById(R.id.score_display);
        scoreSummary.setText(scoreMessage);

    }

    /* This method displays different score message depending on the score range and a toast with number of points */

    public String displayScore (String name, int score) {

        Toast.makeText(this, score + getString(R.string.points), Toast.LENGTH_SHORT).show();

        String scoreMessage;

        if (score <= 3) {
            scoreMessage = getString(R.string.description_1p1) + name + getString(R.string.description_1p2) + score + getString(R.string.description_1p3) +
                    getString(R.string.description_1p4) + getString(R.string.description_1p5) +
                    getString(R.string.description_1p6);
        } else if ((score >= 4) && (score < 8)) {
            scoreMessage = getString(R.string.description_2p1) + name + getString(R.string.description_2p2) + score + getString(R.string.description_2p3) +
                    getString(R.string.description_2p4) +
                    getString(R.string.description_2p5);
        } else {
            scoreMessage = getString(R.string.description_3p1) + name + getString(R.string.description_3p2) + score + getString(R.string.description_3p3) +
                    getString(R.string.description_3p4) + getString(R.string.description_3p5) +
                    getString(R.string.description_3p6) + getString(R.string.description_3p7);
        }
        return scoreMessage;


    }

    /* This method resets the quiz and comes back to the beginning of the ScrollView */

    public void reset (View view) {
        score = 0;

        EditText textField = (EditText) findViewById(R.id.name_field);
        textField.setText(null);

        RadioGroup radio1 = (RadioGroup) findViewById(R.id.radio1);
        radio1.clearCheck();

        RadioGroup radio2 = (RadioGroup) findViewById(R.id.radio2);
        radio2.clearCheck();

        RadioGroup radio3 = (RadioGroup) findViewById(R.id.radio3);
        radio3.clearCheck();

        CheckBox check4a = (CheckBox) findViewById(R.id.answer_4a_cb);
        if (check4a.isChecked()) {
            check4a.toggle();}

        CheckBox check4b = (CheckBox) findViewById(R.id.answer_4b_cb);
        if (check4b.isChecked()) {
            check4b.toggle();
        }

        CheckBox check4c = (CheckBox) findViewById(R.id.answer_4c_cb);
        if (check4c.isChecked()) {
            check4c.toggle();
        }

        RadioGroup radio5 = (RadioGroup) findViewById(R.id.radio5);
        radio5.clearCheck();

        RadioGroup radio6 = (RadioGroup) findViewById(R.id.radio6);
        radio6.clearCheck();

        RadioGroup radio7 = (RadioGroup) findViewById(R.id.radio7);
        radio7.clearCheck();

        EditText answer8 = (EditText) findViewById(R.id.answer_8_et);
        answer8.setText(null);

        RadioGroup radio9 = (RadioGroup) findViewById(R.id.radio9);
        radio9.clearCheck();

        RadioGroup radio10 = (RadioGroup) findViewById(R.id.radio10);
        radio10.clearCheck();

        ScrollView scroll = (ScrollView) findViewById(R.id.scroll);
        scroll.fullScroll(ScrollView.FOCUS_UP);
        scroll.setFocusableInTouchMode(true);

        TextView scoreDisplay = (TextView) findViewById(R.id.score_display);
        scoreDisplay.setText(null);
    }
}


