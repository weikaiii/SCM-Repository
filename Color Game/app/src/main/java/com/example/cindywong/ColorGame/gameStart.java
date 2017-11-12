package com.example.cindywong.ColorGame;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.*;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import java.util.Random;

/**
 * Created by Cindy Wong on 19-Oct-17.
 */

public class gameStart extends AppCompatActivity implements View.OnClickListener {

    Button btnRed, btnBlue, btnGreen, btnYellow, btnPurple, btnGrey;
    TextView tvColor, tvTimer, tvScore;
    Random random;
    int questionLenght, score;
    CountDownTimer gameEndCountdown;

    Integer[] colors = {
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start);
        startTimer();

        questionLenght = tvQuestions.length;
        random = new Random();
        score = 0;

        btnRed=(Button)findViewById(R.id.btnRed);
        btnBlue=(Button)findViewById(R.id.btnBlue);
        btnGreen=(Button)findViewById(R.id.btnGreen);
        btnYellow=(Button)findViewById(R.id.btnYellow);
        btnPurple=(Button)findViewById(R.id.btnPurple);
        btnGrey=(Button)findViewById(R.id.btnGrey);
        tvColor=(TextView) findViewById(R.id.tvColor);
        tvTimer=(TextView) findViewById(R.id.tvTimer);
        tvScore=(TextView) findViewById(R.id.tvScore);

        updateQuestion(random.nextInt(tvQuestions.length));
        tvColor.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), colors[random.nextInt(colors.length)]));

        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
        btnPurple.setOnClickListener(this);
        btnGrey.setOnClickListener(this);
    }

    //start timer function
    void startTimer() {
        gameEndCountdown = new CountDownTimer(31000, 1000) {
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                tvTimer.setText("0");
                gameOver();
            }
        };
        gameEndCountdown.start();
    }

    //cancel timer
    void cancelTimer() {
        if(gameEndCountdown!=null)
            gameEndCountdown.cancel();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRed:
                if (btnRed.getText().toString().equals(tvColor.getText().toString())) {
                    score = Integer.parseInt(tvScore.getText().toString()) + 1;
                    tvScore.setText(Integer.toString(score));
                    updateQuestion(random.nextInt(tvQuestions.length));
                    tvColor.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), colors[random.nextInt(colors.length)]));
                } else {
                    gameOver();
                }
                break;
            case R.id.btnBlue:
                if (btnBlue.getText().toString().equals(tvColor.getText().toString())) {
                    score = Integer.parseInt(tvScore.getText().toString()) + 1;
                    tvScore.setText(Integer.toString(score));
                    updateQuestion(random.nextInt(tvQuestions.length));
                    tvColor.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), colors[random.nextInt(colors.length)]));
                } else {
                    gameOver();
                }
                break;
            case R.id.btnGreen:
                if (btnGreen.getText().toString().equals(tvColor.getText().toString())) {
                    score = Integer.parseInt(tvScore.getText().toString()) + 1;
                    tvScore.setText(Integer.toString(score));
                    updateQuestion(random.nextInt(tvQuestions.length));
                    tvColor.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), colors[random.nextInt(colors.length)]));
                } else {
                    gameOver();
                }
                break;
            case R.id.btnYellow:
                if (btnYellow.getText().toString().equals(tvColor.getText().toString())) {
                    score = Integer.parseInt(tvScore.getText().toString()) + 1;
                    tvScore.setText(Integer.toString(score));
                    updateQuestion(random.nextInt(tvQuestions.length));
                    tvColor.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), colors[random.nextInt(colors.length)]));
                } else {
                    gameOver();
                }
                break;
            case R.id.btnPurple:
                if (btnPurple.getText().toString().equals(tvColor.getText().toString())) {
                    score = Integer.parseInt(tvScore.getText().toString()) + 1;
                    tvScore.setText(Integer.toString(score));
                    updateQuestion(random.nextInt(tvQuestions.length));
                    tvColor.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), colors[random.nextInt(colors.length)]));
                } else {
                    gameOver();
                }
                break;
            case R.id.btnGrey:
                if (btnGrey.getText().toString().equals(tvColor.getText().toString())) {
                    score = Integer.parseInt(tvScore.getText().toString()) + 1;
                    tvScore.setText(Integer.toString(score));
                    updateQuestion(random.nextInt(tvQuestions.length));
                    tvColor.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), colors[random.nextInt(colors.length)]));
                } else {
                    gameOver();
                }
                break;
        }
    }

    public String tvQuestions[] = {"RED","BLUE","GREEN","YELLOW","PURPLE","GREY"};

    private void updateQuestion(int num){
        tvColor.setText(tvQuestions[num]);
    }

    public void gameOver(){
        cancelTimer();

        //Toast toast = Toast.makeText(getApplicationContext(),"Game Over!", Toast.LENGTH_LONG);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        TextView tv = new TextView(gameStart.this);
        tv.setBackgroundColor(Color.BLACK);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(50);
        Typeface t = Typeface.create("serif",Typeface.BOLD);
        tv.setTypeface(t);
        tv.setPadding(10,100,10,100);
        tv.setText("Game Over!");
        toast.setView(tv);
        toast.show();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(gameStart.this);
        alertDialogBuilder
                .setTitle("GAME END")
                .setMessage("Your score is " + score + " points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i){
                                startActivity(new Intent(getApplicationContext(),gameStart.class));
                            }
                        })
                .setNegativeButton("MAIN MENU",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i){
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
