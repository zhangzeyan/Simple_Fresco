package com.simple.fresco;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void normalUseClick(View view) {
        Intent intent = new Intent(MainActivity.this,NormalUseActivity.class);
        startActivity(intent);
    }

    public void controllerListenerClick(View view) {
        Intent intent = new Intent(MainActivity.this,ControllerListenerActivity.class);
        startActivity(intent);
    }

    public void imageRequestClick(View view) {
        Intent intent = new Intent(MainActivity.this,ImageRequestActivity.class);
        startActivity(intent);
    }
}
