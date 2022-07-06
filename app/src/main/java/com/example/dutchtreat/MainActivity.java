package com.example.dutchtreat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    private TextView result1,result2;
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
        result1=(TextView) findViewById(R.id.result1);
        result2=(TextView) findViewById(R.id.result2);
    }
    public void onReset(View v){
        editText1.setText("");
        editText2.setText("");

        result1.setText("結果１");
        result2.setText("結果２");
    }
    public void onClick(View v) {

        String str1 = editText1.getText().toString();
        String str2 = editText2.getText().toString();
        try {
            int Total_Money = Integer.parseInt(str2);
            int Total_Number_of_People = Integer.parseInt(str1);
            Log.i("MainActivity_Main", "totalMoney: " + String.valueOf(Total_Money));
            Log.i("MainActivity_Main", "People: " + String.valueOf(Total_Number_of_People));

            //calculate_about(Total_Money,Total_Number_of_People);
            st18126sh(Total_Money,Total_Number_of_People);


            Log.i("MainActivity_Main", "Money1: " + String.valueOf(Amount_to_Pay_1));
            Log.i("MainActivity_Main", "People1: " + String.valueOf(Number_of_People_1));
            Log.i("MainActivity_Main", "total2: " + String.valueOf(Amount_to_Pay_2));
            Log.i("MainActivity_Main", "People2: " + String.valueOf(Number_of_People_2));

            result1.setText(String.valueOf(Amount_to_Pay_1)+"円 x "+String.valueOf(Number_of_People_1)+"人");

            if(Amount_to_Pay_2!=-1) {
                result2.setText(String.valueOf(Amount_to_Pay_2) + "円 x " + String.valueOf(Number_of_People_2) + "人");
            }else{
                result2.setText("");
            }
        }catch (NumberFormatException e){
            return ;
        }

    }

    private void calculate_about(int Total_Money,int Total_Number_of_People) {



        int divide = 0;

        if (Total_Money % Total_Number_of_People == 0) {
            divide = Total_Money / Total_Number_of_People;
        } else {
            divide = Total_Money / Total_Number_of_People + 1;
        }

        Amount_to_Pay_1=divide;
        Number_of_People_1=Total_Number_of_People;
        Amount_to_Pay_2=-1;
    }

    public void st18126sh( int Total_Money,int Total_Number_of_People) {

        if (Total_Money % Total_Number_of_People == 0) {
            Amount_to_Pay_1 = Total_Money / Total_Number_of_People;
            Number_of_People_1=Total_Number_of_People;
            Amount_to_Pay_2=-1;
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