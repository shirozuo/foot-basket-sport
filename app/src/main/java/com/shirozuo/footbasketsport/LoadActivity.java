package com.shirozuo.footbasketsport;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class LoadActivity extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 3000; //3000ms

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        new Handler().postDelayed((Runnable) () -> {
            Intent intent = new Intent(LoadActivity.this, HomeActivity.class);
            LoadActivity.this.startActivity(intent);
            LoadActivity.this.finish();
        }, SPLASH_DISPLAY_LENGTH);
    }
}