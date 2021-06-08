package com.shirozuo.footbasketsport;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    Button buttonFootball, buttonBasketball;
    public static boolean isFootball;

    public static boolean isFootball() {
        return isFootball;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        buttonFootball = findViewById(R.id.home_football_button);
        buttonBasketball = findViewById(R.id.home_basketball_button);
        click();
    }
    private void click(){
        buttonFootball.setOnClickListener(v -> {
            isFootball = true;
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        });
        buttonBasketball.setOnClickListener(v -> {
            isFootball = false;
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}