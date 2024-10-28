package com.example.testapp;

import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;
import android.widget.Button;
import  android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String getTargetWord(){
        String [] matrix = {"Afghanistan", "Argentina", "Australia", "Austria", "Bangladesh", "Belgium", "Brazil", "Bulgaria", "Canada", "China",
            "Colombia", "Croatia", "Cuba", "Denmark", "Egypt", "Estonia", "Ethiopia", "Finland", "France", "Germany", "Greece", "Hungary",
            "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Japan", "Kenya", "Malaysia", "Mexico", "Morocco",
            "Nepal", "Netherlands", "New Zealand", "Nigeria", "Norway", "Pakistan", "Peru", "Philippines", "Poland", "Portugal", "Russia",
            "Saudi Arabia", "South Africa", "South Korea", "Spain"};
        Random random = new Random();
        return matrix[random.nextInt(50)];
    }

    public static String isMatched(TextView target1, TextView shuffle1, TextView shuffle2, TextView shuffle3){
        if (target1.getText() == shuffle1.getText()) return "You won";
        else if (target1.getText() == shuffle2.getText()) return "You won";
        else if (target1.getText() == shuffle3.getText()) return "You won";
        else return "You Lost";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button targetButton = findViewById(R.id.TargetButton);
        TextView targetText = findViewById(R.id.TargetTextShower);
        Button shuffleButton = findViewById(R.id.button2);
        TextView shuffleText1 = findViewById(R.id.shuffleword1);
        TextView shuffleText2 = findViewById(R.id.shuffleWord2);
        TextView shuffleText3 = findViewById(R.id.shuffleWord3);
        TextView header = findViewById(R.id.textView5);

        targetButton.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    header.setText("Guess The Word Game");
                    targetText.setText(getTargetWord());
                }
            }
        );
        shuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shuffleText1.setText(getTargetWord());
                shuffleText2.setText(getTargetWord());
                shuffleText3.setText(getTargetWord());
                header.setText(isMatched(targetText, shuffleText1, shuffleText2, shuffleText3));
            }
        });
    }
}