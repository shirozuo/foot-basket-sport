package com.shirozuo.footbasketsport;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        new Handler().postDelayed((Runnable) () -> {
            Intent intent = new Intent(LoadActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }, 3*1000);
    }
}