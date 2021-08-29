package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.input_and_result);

        findViewById(R.id.btn_one).setOnClickListener(clickListener);
        findViewById(R.id.btn_two).setOnClickListener(clickListener);
        findViewById(R.id.btn_three).setOnClickListener(clickListener);
        findViewById(R.id.btn_four).setOnClickListener(clickListener);
        findViewById(R.id.btn_five).setOnClickListener(clickListener);
        findViewById(R.id.btn_six).setOnClickListener(clickListener);
        findViewById(R.id.btn_seven).setOnClickListener(clickListener);
        findViewById(R.id.btn_eight).setOnClickListener(clickListener);
        findViewById(R.id.btn_nine).setOnClickListener(clickListener);
        findViewById(R.id.btn_zero).setOnClickListener(clickListener);
        findViewById(R.id.btn_plus).setOnClickListener(clickListener);
        findViewById(R.id.btn_minus).setOnClickListener(clickListener);
        findViewById(R.id.btn_multiplication).setOnClickListener(clickListener);
        findViewById(R.id.btn_division).setOnClickListener(clickListener);
        findViewById(R.id.btn_equals).setOnClickListener(clickListener);
        findViewById(R.id.btn_percent).setOnClickListener(clickListener);
        findViewById(R.id.btn_discharge).setOnClickListener(clickListener);
        findViewById(R.id.btn_comma).setOnClickListener(clickListener);
        findViewById(R.id.btn_plus_or_minus).setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String argOne;
            switch (v.getId()) {
                case R.id.btn_one:
                    argOne = "1";
                    break;
                case R.id.btn_two:
                    argOne = "2";
                    break;
                case R.id.btn_three:
                    argOne = "3";
                    break;
                case R.id.btn_four:
                    argOne = "4";
                    break;
                case R.id.btn_five:
                    argOne = "5";
                    break;
                case R.id.btn_six:
                    argOne = "6";
                    break;
                case R.id.btn_seven:
                    argOne = "7";
                    break;
                case R.id.btn_eight:
                    argOne = "8";
                    break;
                case R.id.btn_nine:
                    argOne = "9";
                    break;
                case R.id.btn_zero:
                    argOne = "0";
                    break;
                case R.id.btn_comma:
                    argOne = ".";
                    break;
                case R.id.btn_discharge:
                    textView.setText("");
                    return;
                default:
                    argOne = "";
            }
            String str = textView.getText() + argOne;
            textView.setText(str);
        }
    };
}