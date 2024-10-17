package com.example.dicegame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView cube1;
    private TextView cube2;
    private TextView cube3;
    private TextView cube4;
    private TextView cube5;
    private TextView drawResult;
    private TextView gameResult;
    private TextView throwAmount;
    private Button throwDraw;
    private Button resetDraw;
    int counter = 0;
    int sum = 0;
    int game = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Textviews
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cube1 = findViewById(R.id.cube1);
        cube2 = findViewById(R.id.cube2);
        cube3 = findViewById(R.id.cube3);
        cube4 = findViewById(R.id.cube4);
        cube5 = findViewById(R.id.cube5);
        drawResult = findViewById(R.id.thisDrawResult);
        gameResult = findViewById(R.id.gameResult);
        throwAmount = findViewById(R.id.throwAmount);
        //Buttons
        throwDraw = findViewById(R.id.throwDraw);
        resetDraw = findViewById(R.id.reset);

        throwDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] drawResults = throwDraw();
                displayDrawResults(drawResults);
                updateDrawCount();
                Score();
                updateScore();
            }
        });
        resetDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetDraw();
            }
        });


    }
    public int[] throwDraw(){
        Random r = new Random();
        int[] values = new int[5];

        for (int i = 0; i < values.length; i++){
            values[i] = r.nextInt(6)+1;
            sum += values[i];
            game += values[i];
        }
        return values;
    }
    public void resetDraw(){
        cube1.setText("?");
        cube2.setText("?");
        cube3.setText("?");
        cube4.setText("?");
        cube5.setText("?");
        counter = 0;
        sum = 0;
        game = 0;
        throwAmount.setText("Liczba rzutow: " + counter);
        gameResult.setText("Wynik gry: " + sum);
        drawResult.setText("Wynik tego losowania: " + game);
        //who could've guessed I'd do it like that, huh?
    }
    public void updateScore(){
        drawResult.setText("Wynik tego losowania: " + game);
        game = 0;
    }
    public void Score(){
        gameResult.setText("Wynik gry: " + sum);
    }
    public void updateDrawCount(){
        counter++;
        throwAmount.setText("Liczba rzutow: " + counter);
    }
    public void displayDrawResults(int[] diceResults){
        cube1.setText(String.valueOf(diceResults[0]));
        cube2.setText(String.valueOf(diceResults[1]));
        cube3.setText(String.valueOf(diceResults[2]));
        cube4.setText(String.valueOf(diceResults[3]));
        cube5.setText(String.valueOf(diceResults[4]));
    }
}