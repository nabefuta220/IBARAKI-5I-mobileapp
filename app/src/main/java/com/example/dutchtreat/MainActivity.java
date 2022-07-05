package com.example.dutchtreat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.dutchtreat.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private TextView textView1;
    private int Amount_to_Pay_1;
    private int Amount_to_Pay_2;
    private int Number_of_People_1;
    private int Number_of_People_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    public void onClick(View v) {

        EditText editText1 = (EditText) findViewById(R.id.text1);
        EditText editText2 = (EditText) findViewById(R.id.text2);
        String str1 = editText1.getText().toString();
        String str2 = editText2.getText().toString();

        int money = Integer.parseInt(str1);
        int number = Integer.parseInt(str2);

        int divide = 0;

        if (money % number == 0) {
            divide = money / number;
        } else {
            divide = money / number + 1;
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