package com.example.cindywong.ColorGame;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnHelp;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart=(Button)findViewById(R.id.btnStart);
        btnHelp=(Button)findViewById(R.id.btnHelp);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),gameStart.class);
                startActivity(intent);

            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar bar = Snackbar.make(v, "Select correct color that match the largest text " +
                        "as many as possible within 30sec. Click START button to begin the game."
                        , Snackbar.LENGTH_LONG)
                        .setDuration(20000)
                        .setAction("CLOSE", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Handle user action
                            }
                        });
                TextView tv = (TextView) bar.getView().findViewById(android.support.design.R.id.snackbar_text);
                tv.setMaxLines(10);
                tv.setTextColor(Color.CYAN);
                tv.setTextSize(20);
                bar.show();
            }
        });

    }


}
