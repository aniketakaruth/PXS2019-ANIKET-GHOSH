package com.example.parxsys.base;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.example.parxsys.R;

public abstract class ToolbarActivity extends BaseActivity {

    Toolbar toolbar;

    ViewStub contentArea;

    TextView toolbarTitle;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_activity);

        toolbar = findViewById(R.id.toolbar);
        contentArea = findViewById(R.id.viewstub_area);
        toolbarTitle=findViewById(R.id.toolbar_text);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        showBackButton(true);

    }


    protected void setView(int layoutId) {
        contentArea.setLayoutResource(layoutId);
        contentArea.inflate();
    }

    protected void showBackButton(boolean showBackButton) {
        if (showBackButton) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
