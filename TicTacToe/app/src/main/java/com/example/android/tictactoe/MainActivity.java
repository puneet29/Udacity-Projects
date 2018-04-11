package com.example.android.tictactoe;

import android.content.res.Resources;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int cell, activePlayer;
    Boolean gameState;
    int stat[] = new int[9];
    int winPosition[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    TextView result;
    LinearLayout prompt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activePlayer = 1;
        for (int i = 0; i < 9; i++) {
            stat[i] = 0;
        }
        gameState = true;
        result = findViewById(R.id.winner);
        prompt = findViewById(R.id.prompt);
    }

    public void crossButton(View view) {
        System.exit(0);
    }

    public void playAgain(View view) {
        prompt.setVisibility(View.INVISIBLE);
        activePlayer = 1;
        RelativeLayout pt = findViewById(R.id.pt);
        for (int i = 0; i < 9; i++) {
            stat[i] = 0;
            ((ImageView) pt.getChildAt(i + 2)).setImageResource(0);
        }
        gameState = true;
    }

    private void animation(final ImageView imageView, int res) {
        imageView.setImageResource(res);
        imageView.animate()
                .scaleYBy(0.1f)
                .scaleXBy(0.1f)
                .rotationBy(360f)
                .setDuration(100);
        stat[cell] = activePlayer;
    }

    private void promptNeeded() {
        prompt.setVisibility(View.VISIBLE);
        gameState = false;
    }

    private void check(int activePlayer) {
        for (int i[] : winPosition) {
            if ((stat[i[0]] == activePlayer) && (stat[i[1]] == activePlayer) && (stat[i[2]] == activePlayer)) {
                result.setText("Player " + activePlayer + " won!");
                promptNeeded();
                return;
            } else {
                gameState = false;
                for (int j : stat) {
                    if (j == 0) {
                        gameState = true;
                    }
                }
                if (!gameState) {
                    result.setText("It is a tie!");
                    promptNeeded();
                }
            }
        }
    }

    public void act(View view) {
        cell = Integer.parseInt(view.getTag().toString());
        ImageView imageView = (ImageView) view;
        if (gameState) {
            if (stat[cell] == 0) {
                if (activePlayer == 1) {
                    animation(imageView, R.mipmap.circle);
                    check(activePlayer);
                    activePlayer = 2;
                } else {
                    animation(imageView, R.mipmap.cross);
                    check(activePlayer);
                    activePlayer = 1;
                }
            }
        }
    }
}
