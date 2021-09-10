package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    CalculateLogic calculateLogic = new CalculateLogic();

    int[] numbers = {
            R.id.btn_one,
            R.id.btn_two,
            R.id.btn_three,
            R.id.btn_four,
            R.id.btn_five,
            R.id.btn_six,
            R.id.btn_seven,
            R.id.btn_eight,
            R.id.btn_nine,
            R.id.btn_zero
    };

    int[] operation = {
            R.id.btn_plus,
            R.id.btn_minus,
            R.id.btn_multiplication,
            R.id.btn_division,
            R.id.btn_equals,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.input_and_result);

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateLogic.numberClick(v.getId());
                textView.setText(calculateLogic.getText());
            }
        };

        View.OnClickListener operationClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateLogic.operationClick(v.getId());
                textView.setText(calculateLogic.getText());
            }
        };

        for (int i = 0; i < numbers.length; i++) {
            findViewById(numbers[i]).setOnClickListener(numberClickListener);
        }

        for (int i = 0; i < operation.length; i++) {
            findViewById(operation[i]).setOnClickListener(operationClickListener);
        }

        findViewById(R.id.btn_discharge).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateLogic.discharge();
                textView.setText(calculateLogic.getText());
            }
        });
    }
}