package com.example.dicethrow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView dice1;
    private ImageView dice2;
    private TextView toggle1dice;
    private TextView toggle2dice;
    private TextView throwDice;
    private TextView resetDice;
    private TextView throwCalculate;
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        toggle1dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dice2.setVisibility(View.GONE);
            }
        });
        toggle2dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dice2.setVisibility(View.VISIBLE);
            }
        });
    }
    public void init(){
        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        toggle1dice = findViewById(R.id.toggle1dice);
        toggle2dice = findViewById(R.id.toggle2dice);
        throwDice = findViewById(R.id.throwDice);
        resetDice = findViewById(R.id.resetDice);
        throwCalculate = findViewById(R.id.throwCalculate);
    }
}