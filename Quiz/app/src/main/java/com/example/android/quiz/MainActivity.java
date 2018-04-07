package com.example.android.quiz;

import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    RadioButton ans;
    int ansid, sum = 0;
    int count[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    private void check(View ans, RadioGroup rg, View v, int num){
        if (count[num] == 1) {
            ansid = ans.getId();

            if (rg.getCheckedRadioButtonId() == ansid) {
                sum += 1;
                ans.setBackgroundResource(R.drawable.shape3);
            } else {
                v.setBackgroundResource(R.drawable.shape2);
                ans.setBackgroundResource(R.drawable.shape3);
            }
        }
        count[num] = 0;
    }

    public void onFirstClick1(View v) {
        ans = findViewById(R.id.q1r3);
        RadioGroup rg = findViewById(R.id.q1rg1);
        check(ans, rg, v, 0);
    }

    public void onFirstClick2(View v) {
        ans = findViewById(R.id.q2r1);
        RadioGroup rg = findViewById(R.id.q2rg2);
        check(ans, rg, v, 1);
    }

    public void onFirstClick3(View v) {
        ans = findViewById(R.id.q3r2);
        RadioGroup rg = findViewById(R.id.q3rg3);
        check(ans, rg, v, 2);
    }

    public void onFirstClick4(View v) {
        ans = findViewById(R.id.q4r1);
        RadioGroup rg = findViewById(R.id.q4rg4);
        check(ans, rg, v, 3);
    }

    public void onFirstClick5(View v) {
        ans = findViewById(R.id.q5r3);
        RadioGroup rg = findViewById(R.id.q5rg5);
        check(ans, rg, v, 4);
    }

    public void onFirstClick6(View v) {
        ans = findViewById(R.id.q6r3);
        RadioGroup rg = findViewById(R.id.q6rg6);
        check(ans, rg, v, 5);
    }

    public void onFirstClick7(View v) {
        ans = findViewById(R.id.q7r4);
        RadioGroup rg = findViewById(R.id.q7rg7);
        check(ans, rg, v, 6);
    }

    public void onFirstClick8(View v) {
        ans = findViewById(R.id.q8r2);
        RadioGroup rg = findViewById(R.id.q8rg8);
        check(ans, rg, v, 7);
    }

    public void onFirstClick9(View v) {
        ans = findViewById(R.id.q9r3);
        RadioGroup rg = findViewById(R.id.q9rg9);
        check(ans, rg, v, 8);
    }

    public void onFirstClick10(View v) {
        ans = findViewById(R.id.q10r1);
        RadioGroup rg = findViewById(R.id.q10rg10);
        check(ans, rg, v, 9);
    }

    public void results(View v) {
        Toast.makeText(this, getString(R.string.results, sum), Toast.LENGTH_LONG).show();
    }

}
