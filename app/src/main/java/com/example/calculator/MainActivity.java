package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button btn_clear, btn_bracket, btn_percent, btn_divide, btn_multiply, btn_minus, btn_plus, btn_equals;
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_dot;
    TextView txt_input, txt_output;
    String process;
    boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_clear = findViewById(R.id.btn_clear);
        btn_bracket = findViewById(R.id.btn_bracket);
        btn_percent = findViewById(R.id.btn_percent);
        btn_divide = findViewById(R.id.btn_division);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_equals = findViewById(R.id.btn_equal);
        btn_dot = findViewById(R.id.btnDot);

        txt_input = findViewById(R.id.txt_input);
        txt_output = findViewById(R.id.txt_output);

        btn_0 = findViewById(R.id.btn0);
        btn_1 = findViewById(R.id.btn1);
        btn_2 = findViewById(R.id.btn2);
        btn_3 = findViewById(R.id.btn3);
        btn_4 = findViewById(R.id.btn4);
        btn_5 = findViewById(R.id.btn5);
        btn_6 = findViewById(R.id.btn6);
        btn_7 = findViewById(R.id.btn7);
        btn_8 = findViewById(R.id.btn8);
        btn_9 = findViewById(R.id.btn9);

        //Set screen to empty on start
        txt_input.setText("");
        txt_output.setText("");

        //Set onClickListener for all buttons
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_input.setText("");
                txt_output.setText("");
                process = "";
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "9");
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "+");
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "-");
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "×");
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "÷");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + ".");
            }
        });

        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = txt_input.getText().toString();
                txt_input.setText(process + "%");
            }
        });

        btn_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBracket) {
                    process = txt_input.getText().toString();
                    txt_input.setText(process + "(");
                    checkBracket = false;
                } else {
                    process = txt_input.getText().toString();
                    txt_input.setText(process + ")");
                    checkBracket = true;
                }
            }
        });

        //Do the instructions here on press of equals button
        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get string from input box
                process = txt_input.getText().toString();

                process = process.replaceAll("÷", "/");
                process = process.replaceAll("×", "*");
                process = process.replaceAll("%", "/100");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";
                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    finalResult = "Error";
                }

                txt_output.setText(finalResult);
            }
        });

    }
}
