package com.example.dutchtreat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    private TextView textView1;
    private int Amount_to_Pay_1;
    private int Amount_to_Pay_2;
    private int Number_of_People_1;
    private int Number_of_People_2;
    private EditText editText1;
    private EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/**/
        editText1 = (EditText) findViewById(R.id.text_label_person);
        editText2 = (EditText) findViewById(R.id.text_label_price);
    }

    public void onClick(View v) {

        String str1 = editText1.getText().toString();
        String str2 = editText2.getText().toString();
        int Total_Money = Integer.parseInt(str1);
        int Total_Number_of_People = Integer.parseInt(str2);
        Log.i("MainActivity_Main", String.valueOf(Total_Money));
        Log.i("MainActivity_Main", String.valueOf(Total_Number_of_People));
        calculate_about(Total_Money,Total_Number_of_People);
        st18126sh(Total_Money,Total_Number_of_People);
    }

    private void calculate_about(int Total_Money,int Total_Number_of_People) {



        int divide = 0;

        if (Total_Money % Total_Number_of_People == 0) {
            divide = Total_Money / Total_Number_of_People;
        } else {
            divide = Total_Money / Total_Number_of_People + 1;
        }

        String str3 = String.valueOf(divide);
        textView1.setText(str3);
    }

    public void st18126sh(int Total_Number_of_People, int Total_Money) {

        if (Total_Money % Total_Number_of_People == 0) {
            Amount_to_Pay_1 = Total_Money / Total_Number_of_People;
        } else {
            int x;
            x = Total_Money % Total_Number_of_People;
            int y = Total_Money - x;
            Amount_to_Pay_1 = y / Total_Number_of_People;
            Number_of_People_1 = Total_Number_of_People - x;
            Amount_to_Pay_2 = Amount_to_Pay_1 + 1;
            Number_of_People_2 = x;
        }
    }
}