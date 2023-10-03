package com.example.dicethrow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView dice1;
    private ImageView dice2;
    private TextView toggle1dice;
    private TextView toggle2dice;
    private TextView throwDice;
    private TextView resetDice;
    private TextView throwCalculate;
    private int result1;
    private int result2;
    private Random rnd = new Random();
    private boolean diceAre2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        toggle1dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dice2.setVisibility(View.GONE);
                diceAre2 = false;
            }
        });
        toggle2dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dice2.setVisibility(View.VISIBLE);
                diceAre2 = true;
            }
        });
        throwDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = throwCalculate.getText().toString();
                if (diceAre2 == false){
                    throwTheDice(0, rnd.nextInt(6) + 1);
                    throwCalculate.setText(s + result2 + "\n");
                }else {
                    throwTheDice(rnd.nextInt(6) + 1, rnd.nextInt(6) + 1);
                    throwCalculate.setText(String.format("%s%s (%s + %s)\n", s,(result1+result2),  result1, result2));
                }
            }
        });
        resetDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBoard();
            }
        });
    }
    public void resetBoard(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Biztos, hogy törölni szeretné az eddigi dobásokat?")
                .setCancelable(false)
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        throwCalculate.setText("");
                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
    }
    public void throwTheDice(int throw1, int throw2){
        result1 = throw1;
        result2 = throw2;
            switch (throw1){
                case 0:
                    break;
                case 1:
                    dice1.setImageResource(R.drawable.kocka1);
                    break;
                case 2:
                    dice1.setImageResource(R.drawable.kocka2);
                    break;
                case 3:
                    dice1.setImageResource(R.drawable.kocka3);
                    break;
                case 4:
                    dice1.setImageResource(R.drawable.kocka3);
                    break;
                case 5:
                    dice1.setImageResource(R.drawable.kocka3);
                    break;
                case 6:
                    dice1.setImageResource(R.drawable.kocka3);
                    break;
            }
            switch (throw2) {
                case 1:
                    dice2.setImageResource(R.drawable.kocka1);
                    break;
                case 2:
                    dice2.setImageResource(R.drawable.kocka2);
                    break;
                case 3:
                    dice2.setImageResource(R.drawable.kocka3);
                    break;
                case 4:
                    dice2.setImageResource(R.drawable.kocka3);
                    break;
                case 5:
                    dice2.setImageResource(R.drawable.kocka3);
                    break;
                case 6:
                    dice2.setImageResource(R.drawable.kocka3);
                    break;
            }
            String toastString = String.valueOf(result1+result2);
        Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();
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