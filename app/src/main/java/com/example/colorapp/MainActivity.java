package com.example.colorapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private EditText redText,greenText,blueText;
    private TextView redScreen,greenScreen,blueScreen,mixScreen;
    private SeekBar redBar,greenBar,blueBar;
    private int red,green,blue;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFields();
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void initFields(){
        //input
        redText = findViewById(R.id.RedText);
        redText.setOnClickListener(this :: setRedText);
        greenText = findViewById(R.id.GreenText);
        greenText.setOnClickListener(this :: setGreenText);
        blueText = findViewById(R.id.BlueText);
        blueText.setOnClickListener(this::setBlueText);
        //screen
        redScreen = findViewById(R.id.RedBlock);
        greenScreen = findViewById(R.id.GreenBlock);
        blueScreen = findViewById(R.id.BlueBlock);
        mixScreen = findViewById(R.id.MixedScreen);
        //bars
        redBar = findViewById(R.id.RedBar);
        redBar.setMax(255);
        redBar.setMin(0);
        redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                red = redBar.getProgress();
                update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        greenBar = findViewById(R.id.GreenBar);
        greenBar.setMax(255);
        greenBar.setMin(0);
        greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                green = greenBar.getProgress();
                update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        blueBar= findViewById(R.id.BlueBar);
        blueBar.setMax(255);
        blueBar.setMin(0);
        blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                blue = blueBar.getProgress();
                update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void initView(){
        red = 255;
        green = 255;
        blue = 255;
        update();
    }

    public boolean isVaildValue(int colorValue){
        if(colorValue > 255 || colorValue < 0){
            return false;
        } else {
            return true;
        }
    }

    public void setRedText(View view){
            int num = Integer.parseInt(redText.getText().toString());
            if (isVaildValue(num)) {
                red = num;
                update();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Invaild Value for Red", Toast.LENGTH_SHORT);
                toast.show();
            }
    }

    public void setGreenText(View view) {
            int num = Integer.parseInt(greenText.getText().toString());
            if (isVaildValue(num)) {
                green = num;
                update();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Invaild Value for Green", Toast.LENGTH_SHORT);
                toast.show();
            }
    }

    public void setBlueText(View view){
            int num = Integer.parseInt(blueText.getText().toString());
            if (isVaildValue(num)) {
                blue = num;
                update();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Invaild Value for Blue", Toast.LENGTH_SHORT);
                toast.show();
            }
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {}

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void update(){
        redText.setText(Integer.toString(red));
        redScreen.setBackgroundColor(Color.rgb(red,0,0));
        redScreen.setText(String.format(Integer.toString(red)));
        redBar.setProgress(red);
        greenText.setText(Integer.toString(green));
        greenScreen.setBackgroundColor(Color.rgb(0,green,0));
        greenScreen.setText(String.format(Integer.toString(green)));
        greenBar.setProgress(green);
        blueText.setText(Integer.toString(blue));
        blueScreen.setBackgroundColor(Color.rgb(0,0,blue));
        blueScreen.setText(String.format(Integer.toString(blue)));
        blueBar.setProgress(blue);
        mixScreen.setBackgroundColor(Color.rgb(red,green,blue));

    }
}
