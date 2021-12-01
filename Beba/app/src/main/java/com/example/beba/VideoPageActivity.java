package com.example.beba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VideoPageActivity extends AppCompatActivity {
    public static final String DELIVERY = "com.example.myFirstApp.DELIVERY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_page);
    }

    public void delivery(View view) {
        Intent intent = new Intent(this, DeliveryPage.class);
        TextView textView = (TextView) findViewById(R.id.account);
        String delivery = textView.getText().toString();
        intent.putExtra(DELIVERY,delivery);
        startActivity(intent);
    
    }
}
