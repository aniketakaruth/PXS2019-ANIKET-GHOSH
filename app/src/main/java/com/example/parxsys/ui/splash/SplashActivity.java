package com.example.parxsys.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.parxsys.R;
import com.example.parxsys.ui.splash.SplashFragment;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SplashFragment.newInstance())
                    .commitNow();
        }
    }
}
